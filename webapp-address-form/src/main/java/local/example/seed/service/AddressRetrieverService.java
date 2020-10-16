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

import local.example.seed.client.AddressWebClient;
import local.example.seed.model.Address;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AddressRetrieverService {

    private static final URI RESTFUL_ADDRESS_BASE_URI = URI.create("http://127.0.0.1:8080/");

    private final AddressWebClient addressWebClient;

    public AddressRetrieverService() {
        this.addressWebClient = new AddressWebClient();
    }

    public void create(Address address) {
        this.addressWebClient.create(address);
    }

    public Optional<Address> read(String uri) {
        Mono<Address> addressMono = this.addressWebClient.read(uri);
        return Optional.ofNullable(addressMono.block());
    }

    public Collection<Address> readAll() {
        Traverson traverson = new Traverson(
                RESTFUL_ADDRESS_BASE_URI,
                MediaTypes.HAL_JSON
        );
        Traverson.TraversalBuilder traversalBuilder = traverson.follow("addresses");
        ParameterizedTypeReference<CollectionModel<Address>> parameterizedTypeReference;
        parameterizedTypeReference = new ParameterizedTypeReference<>() {};
        CollectionModel<Address> collectionModelOfAddresses;
        collectionModelOfAddresses = traversalBuilder.toObject(parameterizedTypeReference);
        Collection<Address> collectionOfAddresses = collectionModelOfAddresses.getContent();
        List<Address> addresses = new ArrayList<>(collectionOfAddresses);
        return addresses;
    }

    public void update(Address address, String uri) {
        this.addressWebClient.update(address, uri);
    }

    public void delete(String uri) {
        Mono<Address> addressMono = this.addressWebClient.read(uri);
        if (addressMono.block() != null && addressMono.block() != Mono.empty().block()) {
            this.addressWebClient.delete(uri);
        }
    }
}
