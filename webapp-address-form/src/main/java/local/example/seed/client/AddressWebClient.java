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
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AddressWebClient {

    private final WebClient webClient;

    public AddressWebClient() {
        webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<Address> create(Address address) {
        return this.webClient
                .post()
                .uri("/addresses")
                .body(Mono.just(address), Address.class)
                .retrieve()
                .bodyToMono(Address.class);
    }

    public Mono<Address> read(Address address) {
        // TODO
        return null;
    }

    public Flux<Address> readAll() {
        // TODO
        return null;
    }

    public Mono<Address> update(Address address, String id) {
        // TODO
        return null;
    }

    public Mono<Address> partialUpdate() {
        // TODO
        return null;
    }

    public Mono<Void> delete(String id) {
        // TODO
        return null;
    }
}
