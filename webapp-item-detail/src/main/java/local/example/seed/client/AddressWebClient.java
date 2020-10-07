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

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import local.example.seed.model.Address;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class AddressWebClient {

    private final WebClient webClient;

    public AddressWebClient() {
        TcpClient tcpClient = TcpClient.create()
                .option(
                        ChannelOption.CONNECT_TIMEOUT_MILLIS, 6000
                )
                .doOnConnected(
                        connection -> {
                            connection.addHandlerLast(
                                    new ReadTimeoutHandler(6000, TimeUnit.MILLISECONDS));
                            connection.addHandlerLast(
                                    new WriteTimeoutHandler(6000, TimeUnit.MILLISECONDS));
                        }
                );
        webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .clientConnector(
                        new ReactorClientHttpConnector(HttpClient.from(tcpClient))
                )
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Mono<Address> create(Address address) {
        return this.webClient
                .post()
                .uri("/addresses")
                .body(Mono.just(address), Address.class)
                .retrieve()
                .onStatus(
                        httpStatus -> !HttpStatus.CREATED.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Address.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    System.out.println(timestamp + "ERROR: --- Connection refused, probably the host is down! ---");
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Mono<Address> read(String id) {
        return this.webClient
                .get()
                .uri("/addresses/"+id)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Address.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    System.out.println(timestamp + "ERROR: --- Connection refused, probably the host is down! ---");
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Flux<Address> readAll() {
        return this.webClient
                .get()
                .uri("/addresses")
                .retrieve()
                .onStatus(
                        HttpStatus::isError,
                        clientResponse -> Mono.empty()
                )
                .bodyToFlux(Address.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    System.out.println(timestamp + "ERROR: --- Connection refused, probably the host is down! ---");
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Mono<Address> update(Address address, String id) {
        return this.webClient
                .put()
                .uri("/addresses/"+id)
                .body(Mono.just(address), Address.class)
                .retrieve()
                .onStatus(
                        httpStatus -> !HttpStatus.OK.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Address.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    System.out.println(timestamp + "ERROR: --- Connection refused, probably the host is down! ---");
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Mono<Address> partialUpdate(Address address, String id) {
        return this.webClient
                .patch()
                .uri("/addresses/"+id)
                .body(Mono.just(address), Address.class)
                .retrieve()
                .onStatus(
                        httpStatus -> !HttpStatus.OK.equals(httpStatus),
                        clientResponse -> Mono.empty()
                )
                .bodyToMono(Address.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    System.out.println(timestamp + "ERROR: --- Connection refused, probably the host is down! ---");
                })
                .onErrorResume(exception -> Mono.empty());
    }

    public Mono<Void> delete(String id) {
        return this.webClient
                .delete()
                .uri("/addresses/"+id)
                .retrieve()
                .onStatus(
                        httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> {
                            System.out.println("HTTP status error: address not found!");
                            return Mono.empty();
                        }
                )
                .bodyToMono(Void.class)
                .doOnError(exception -> {
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    System.out.println(timestamp + "ERROR: --- Connection refused, probably the host is down! ---");
                });
    }
}
