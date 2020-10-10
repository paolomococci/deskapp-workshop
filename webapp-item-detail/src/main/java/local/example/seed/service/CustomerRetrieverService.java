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

package local.example.seed.service;

import local.example.seed.client.CustomerWebClient;
import local.example.seed.model.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomerRetrieverService {

    private CustomerWebClient customerWebClient;

    public CustomerRetrieverService() {
        this.customerWebClient = new CustomerWebClient();
    }

    public void create(String id) {
        Mono<Customer> customerMono = this.customerWebClient.read(id);
        // TODO
    }

    public Collection<Customer> readAll() {
        // TODO
        return new ArrayList<>();
    }

    public void update(Customer customer, String id) {
        Mono<Customer> customerMono = this.customerWebClient.update(customer, id);
        // TODO
    }

    public void delete(String id) {
        Mono<Customer> customerMono = this.customerWebClient.read(id);
        if (customerMono.block() != null && customerMono.block() != Mono.empty().block()) {
            // TODO
        }
    }
}
