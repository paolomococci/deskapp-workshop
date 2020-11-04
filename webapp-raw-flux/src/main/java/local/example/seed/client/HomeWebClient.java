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

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class HomeWebClient {

    private WebClient webClient = WebClient.create("http://127.0.0.1:8000");

    private Mono<ClientResponse> clientResponseMono = webClient.get()
            .uri("/")
            .accept(MediaType.TEXT_HTML)
            .exchange();

    public String getClientResponseMono() {
        return clientResponseMono.flatMap(
                clientResponse -> clientResponse.bodyToMono(String.class)
        ).block();
    }
}
