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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.sql.Timestamp;

public class AddressWebClient {

    @Autowired
    private WebClient webClient = WebClient.create();

    private final static URI ADDRESSES_RESTFUL_URI = URI.create("http://localhost:8080/addresses");

    public void create(Address address) {
        this.webClient
                .post()
                .uri(ADDRESSES_RESTFUL_URI)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(address), Address.class)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> !HttpStatus.CREATED.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Void.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    System.out.println(timestamp +
                            " ERROR: --- Connection refused, an error occurred during a request create address, probably the host is down! ---\n" +
                            address.toString());
                })
                .block();
    }

    public Mono<Address> read(String uri) {
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
                                    " HTTP status error: 404 --- address not found, an error occurred during a request read address's uri: %s ---",
                                    uri
                            );
                            System.out.println(timestamp + errorMessage);
                            return Mono.empty();
                        }
                )
                .bodyToMono(Address.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String errorMessage = String.format(
                            " ERROR: --- Connection refused, an error occurred during a request read address's uri': %s, probably the host is down! ---",
                            uri
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public void update(Address address, String uri) {
        this.webClient
                .put()
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(address), Address.class)
                .accept(MediaTypes.HAL_JSON)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                            String errorMessage = String.format(
                                    " HTTP status error: 404 --- customer not found, an error occurred during a request to the address's uri: %s ---",
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
                            " ERROR: --- Connection refused, an error occurred during a request update address's uri: %s, probably the host is down! ---",
                            uri
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .block();
    }

    public Mono<Address> partialUpdate(Address address, String uri) {
        return this.webClient
                .patch()
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
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
                            " ERROR: --- Connection refused, an error occurred during a request partial update address's id: %s, probably the host is down! ---",
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
                                    " HTTP status error: 404 --- address not found, an error occurred during a request delete address's uri: %s ---",
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
                            " ERROR: --- Connection refused, an error occurred during a request delete address's uri: %s, probably the host is down! ---",
                            uri
                    );
                    System.out.println(timestamp + errorMessage);
                })
                .block();
    }
}
