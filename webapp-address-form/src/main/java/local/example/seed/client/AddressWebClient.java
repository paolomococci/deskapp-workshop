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

import local.example.seed.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

public class AddressWebClient {

    @Autowired
    private WebClient webClient = WebClient.create();

    public Mono<Address> create(Address address) {
        return this.webClient
                .post()
                .uri("http://localhost:8080/addresses")
                .body(Mono.just(address), Address.class)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> !HttpStatus.CREATED.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Address.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    System.out.println(timestamp +
                            " ERROR: --- Connection refused occurred during a request create address, probably the host is down! ---\n" +
                            address.toString());
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Mono<Address> read(String id) {
        return this.webClient
                .get()
                .uri("http://localhost:8080/addresses/{id}", id)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- address not found occurred during a request read address id: %s ---",
                                    id
                            );
                            System.out.println(timestamp + errorMessage);
                            return Mono.empty();
                        }
                )
                .bodyToMono(Address.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused occurred during a request read address id: %s, probably the host is down! ---",
                            id
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Mono<Address> update(Address address, String id) {
        return this.webClient
                .put()
                .uri("http://localhost:8080/addresses/{id}", id)
                .body(Mono.just(address), Address.class)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> !HttpStatus.OK.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Address.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused occurred during a request update address id: %s, probably the host is down! ---",
                            id
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Mono<Address> partialUpdate(Address address, String id) {
        return this.webClient
                .patch()
                .uri("http://localhost:8080/addresses/{id}", id)
                .body(Mono.just(address), Address.class)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> !HttpStatus.OK.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Address.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused occurred during a request partial update address id: %s, probably the host is down! ---",
                            id
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Mono<Void> delete(String id) {
        return this.webClient
                .delete()
                .uri("http://localhost:8080/addresses/{id}", id)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- address not found occurred during a request delete address id: %s ---",
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
                            " ERROR: --- Connection refused occurred during a request delete address id: %s, probably the host is down! ---",
                            id
                    );
                    System.out.println(timestamp + errorMessage);
                });
    }
}
