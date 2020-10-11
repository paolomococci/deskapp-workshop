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

package local.example.seed.client;

import local.example.seed.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

public class CustomerWebClient {

    @Autowired
    private WebClient webClient = WebClient.create();

    public Mono<Customer> create(Customer customer) {
        return this.webClient
                .post()
                .uri("http://127.0.0.1:8080/customers")
                .body(Mono.just(customer), Customer.class)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> !HttpStatus.CREATED.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Customer.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    System.out.println(timestamp +
                            " ERROR: --- Connection refused occurred during a request create customer, probably the host is down! ---\n" +
                            customer.toString());
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Mono<Customer> read(String id) {
        return this.webClient
                .get()
                .uri("http://127.0.0.1:8080/customers/"+id)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- customer not found occurred during a request read customer id: %s ---",
                                    id
                            );
                            System.out.println(timestamp + errorMessage);
                            return Mono.empty();
                        }
                )
                .bodyToMono(Customer.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused occurred during a request read customer id: %s, probably the host is down! ---",
                            id
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Mono<Customer> update(Customer customer, String id) {
        return this.webClient
                .put()
                .uri("http://127.0.0.1:8080/customers/"+id)
                .body(Mono.just(customer), Customer.class)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> !HttpStatus.OK.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Customer.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused occurred during a request update customer id: %s, probably the host is down! ---",
                            id
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Mono<Customer> partialUpdate(Customer customer, String id) {
        return this.webClient
                .patch()
                .uri("http://127.0.0.1:8080/customers/"+id)
                .body(Mono.just(customer), Customer.class)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> !HttpStatus.OK.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Customer.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused occurred during a request partial update customer id: %s, probably the host is down! ---",
                            id
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Mono<Void> delete(String id) {
        return this.webClient
                .delete()
                .uri("http://127.0.0.1:8080/customers/"+id)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- customer not found occurred during a request delete customer id: %s ---",
                                    id
                            );
                            System.out.println(timestamp + errorMessage);
                            return Mono.empty();
                        }
                )
                .bodyToMono(Void.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused occurred during a request delete customer id: %s, probably the host is down! ---",
                            id
                    );
                    System.out.println(timestamp + errorMessage);
                });
    }

    public Mono<Customer> findByEmail(String email) {
        return this.webClient
                .get()
                .uri("http://127.0.0.1:8080/customers/search/findByEmail?email="+email)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- customer not found occurred during a request read customer id: %s ---",
                                    email
                            );
                            System.out.println(timestamp + errorMessage);
                            return Mono.empty();
                        }
                )
                .bodyToMono(Customer.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused occurred during a request read customer id: %s, probably the host is down! ---",
                            email
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .onErrorResume(exception -> Mono.empty());
    }
}
