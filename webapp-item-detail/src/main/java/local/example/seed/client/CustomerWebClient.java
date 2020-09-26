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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CustomerWebClient {

    private final WebClient webClient;

    public CustomerWebClient() {
        webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<Customer> create(Customer customer) {
        return this.webClient
                .post()
                .uri("/customers")
                .body(Mono.just(customer), Customer.class)
                .retrieve()
                .onStatus(
                        httpStatus -> !HttpStatus.CREATED.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Customer.class);
    }

    public Mono<Customer> read(String id) {
        return this.webClient
                .get()
                .uri("/customers/"+id)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Customer.class);
    }

    public Flux<Customer> readAll() {
        return this.webClient
                .get()
                .uri("/customers")
                .retrieve()
                .bodyToFlux(Customer.class);
    }

    public Mono<Customer> update(Customer customer, String id) {
        // TODO
        return null;
    }

    public Mono<Customer> partialUpdate(Customer customer, String id) {
        // TODO
        return null;
    }

    public Mono<Void> delete(String id) {
        // TODO
        return null;
    }
}
