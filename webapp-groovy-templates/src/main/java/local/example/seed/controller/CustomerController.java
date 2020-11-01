/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.seed.controller;

import local.example.seed.document.Customer;
import local.example.seed.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer-create")
    public String createCustomer(@ModelAttribute Customer customer) {
        this.customerRepository.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer")
    public ModelAndView customers() {
        Map<String, Iterable<Customer>> linkedHashMap;
        linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("customers", this.customerRepository.findAll());
        return new ModelAndView("customer", linkedHashMap);
    }

    @PostMapping("/customer-update")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        Optional<Customer> optionalCustomer;
        try {
            optionalCustomer = this.customerRepository.findById(customer.getId()).map(
                    updatable -> {
                        updatable.setName(customer.getName());
                        updatable.setSurname(customer.getSurname());
                        updatable.setEmail(customer.getEmail());
                        this.customerRepository.save(updatable);
                        return updatable;
                    }
            );
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp + " --- INFO --- Customer data has been correctly updated: " + optionalCustomer.toString());
        } catch (NullPointerException nullPointerException) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp + " --- ERROR --- An error occurred while trying to update the customer data by ID: " + customer.getId());
            nullPointerException.printStackTrace();
        }
        return "redirect:/customer";
    }

    @GetMapping("/customer-update/{id}")
    public ModelAndView updateCustomerById(@PathVariable("id") String id) {
        Map<String, Customer> linkedHashMap;
        linkedHashMap = new LinkedHashMap<>(1);
        linkedHashMap.put("updated", this.customerRepository.findById(id).get());
        return new ModelAndView("customer-update", linkedHashMap);
    }

    @GetMapping("/customer-delete/{id}")
    public String deleteCustomer(@PathVariable("id") String id) {
        this.customerRepository.deleteById(id);
        return "redirect:/customer";
    }
}
