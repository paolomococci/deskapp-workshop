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
import local.example.seed.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.sql.Timestamp;
import java.util.List;

public class CustomerWebClient {

    @Autowired
    private final WebClient webClient = WebClient.create();

    private final static URI CUSTOMERS_RESTFUL_URI = URI.create("http://127.0.0.1:8080/customers");

    public void create(Customer customer) {
        this.webClient
                .post()
                .uri(CUSTOMERS_RESTFUL_URI)
                .body(Mono.just(customer), Customer.class)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
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
                .block();
    }

    public Mono<Customer> read(String uri) {
        return this.webClient
                .get()
                .uri(uri)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- customer not found, an error occurred during a request to the customer's uri: %s ---",
                                    uri
                            );
                            System.out.println(timestamp + errorMessage);
                            return Mono.empty();
                        }
                )
                .bodyToMono(Customer.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused, an error occurred during a request to the customer's uri: %s, probably the host is down! ---",
                            uri
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public List<Customer> readAll() {
        return this.getResponseFlux(
                this.getResponseFlux(0).blockFirst().getPage().getTotalElements()
        ).blockFirst().get_embedded().getCustomers();
    }

    public Flux<Response> readAllPaged(int page) {
        return this.webClient.get()
                .uri(CUSTOMERS_RESTFUL_URI+"?page={page}&size=10", page)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- customer not found, an error occurred during a request to the customers uri: %s ---",
                                    CUSTOMERS_RESTFUL_URI.toString()
                            );
                            System.out.println(timestamp + errorMessage);
                            return Mono.empty();
                        }
                )
                .bodyToFlux(Response.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused, an error occurred during a request to the customers uri: %s, probably the host is down! ---",
                            CUSTOMERS_RESTFUL_URI.toString()
                    );
                    System.out.println(timestamp + errorMessage);
                });
    }

    public void update(Customer customer, String uri) {
        this.webClient
                .put()
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(customer), Customer.class)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- customer not found, an error occurred during a request to the customer's uri: %s ---",
                                    uri
                            );
                            System.out.println(timestamp + errorMessage);
                            return Mono.empty();
                        }
                )
                .bodyToMono(Void.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused, an error occurred during a request to the customer's uri: %s, probably the host is down! ---",
                            uri
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .block();
    }

    public Mono<Customer> partialUpdate(Customer customer, String uri) {
        return this.webClient
                .patch()
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(customer), Customer.class)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- customer not found, an error occurred during a request to the customer's uri: %s ---",
                                    uri
                            );
                            System.out.println(timestamp + errorMessage);
                            return Mono.empty();
                        }
                )
                .bodyToMono(Customer.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused, an error occurred during a request to the customer's uri: %s, probably the host is down! ---",
                            uri
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public void delete(String uri) {
        this.webClient
                .delete()
                .uri(uri)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- customer not found, an error occurred during a request to the customer's uri: %s ---",
                                    uri
                            );
                            System.out.println(timestamp + errorMessage);
                            return Mono.empty();
                        }
                )
                .bodyToMono(Void.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused, an error occurred during a request to the customer's uri: %s, probably the host is down! ---",
                            uri
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .block();
    }

    public Mono<Customer> findByEmail(String email) {
        return this.webClient
                .get()
                .uri("http://127.0.0.1:8080/customers/search/findByEmail?email={email}", email)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- customer not found, an error occurred during a search request for the customer's email: %s ---",
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
                            " ERROR: --- Connection refused, an error occurred during a search request for the customer's email: %s, probably the host is down! ---",
                            email
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .onErrorResume(exception -> Mono.empty());
    }

    private Flux<Response> getResponseFlux(int size) {
        return this.webClient.get()
                .uri(CUSTOMERS_RESTFUL_URI+"?page=0&size={size}", size)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- customer not found, an error occurred during a request to the customers uri: %s ---",
                                    CUSTOMERS_RESTFUL_URI.toString()
                            );
                            System.out.println(timestamp + errorMessage);
                            return Mono.empty();
                        }
                )
                .bodyToFlux(Response.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused, an error occurred during a request to the customers uri: %s, probably the host is down! ---",
                            CUSTOMERS_RESTFUL_URI.toString()
                    );
                    System.out.println(timestamp + errorMessage);
                });
    }
}
