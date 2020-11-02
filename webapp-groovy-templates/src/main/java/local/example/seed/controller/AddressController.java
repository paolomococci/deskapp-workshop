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

import local.example.seed.document.Address;
import local.example.seed.repository.AddressRepository;
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
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/address-create")
    public String createAddress(@ModelAttribute Address address) {
        this.addressRepository.save(address);
        return "redirect:/address";
    }

    @GetMapping("/address")
    public ModelAndView readAllAddress() {
        Map<String, Iterable<Address>> linkedHashMap;
        linkedHashMap = new LinkedHashMap<>(1);
        linkedHashMap.put("addresses", this.addressRepository.findAll());
        return new ModelAndView("address", linkedHashMap);
    }

    @PostMapping("/address-update")
    public String updateAddress(@ModelAttribute("address") Address address) {
        try {
            this.addressRepository.findById(address.getId()).ifPresent(
                    updatable -> {
                        updatable.setCountry(address.getCountry());
                        updatable.setCity(address.getCity());
                        updatable.setStreet(address.getStreet());
                        updatable.setCivic(address.getCivic());
                        updatable.setCode(address.getCode());
                        this.addressRepository.save(updatable);
                    }
            );
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp + " --- INFO --- Data has been correctly updated, address id: " + address.getId());
        } catch (NullPointerException nullPointerException) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp + "ERROR --- An error occurred while trying to update the address data by ID: " + address.getId());
            nullPointerException.printStackTrace();
        }
        return "redirect:/address";
    }

    @GetMapping("/address-update/{id}")
    public ModelAndView updateAddressById(@PathVariable("id") String id) {
        Map<String, Address> linkedHashMap;
        linkedHashMap = new LinkedHashMap<>(1);
        Optional<Address> optionalAddress;
        optionalAddress = this.addressRepository.findById(id);
        linkedHashMap.put("updated", optionalAddress.get());
        return new ModelAndView("address-update", linkedHashMap);
    }

    @GetMapping("/address-delete/{id}")
    public String deleteAddress(@PathVariable("id") String id) {
        this.addressRepository.deleteById(id);
        return "redirect:/address";
    }
}
