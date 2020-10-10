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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerWebClientTests {

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    public void init() {
        this.webTestClient
                .mutate()
                .responseTimeout(Duration.ofMillis(36000))
                .build();
    }

    @Test
    public void readAllTest() {
        this.webTestClient.get()
                .uri("http://127.0.0.1:8080/customers")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody().consumeWith(
                    response -> Assertions.assertThat(response.getResponseBody()).isNotNull()
        );
    }

    @Test
    public void readTest() {
        this.webTestClient.get()
                .uri("http://127.0.0.1:8080/customers/5f816d8bfd149b2f6178ea82")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody().consumeWith(
                response -> Assertions.assertThat(response.getResponseBody()).isNotNull()
        );
    }
}
