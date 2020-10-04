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
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AddressRetrieverService {

    private final AddressWebClient addressWebClient;

    public AddressRetrieverService() {
        this.addressWebClient = new AddressWebClient();
    }

    public Collection<Address> readAll() {
        Flux<Address> addressFlux = this.addressWebClient.readAll();
        Collection<Address> addresses = addressFlux.collectSortedList().block();
        if (addresses.isEmpty()) {
            return new ArrayList<>();
        }
        return addresses;
    }
}
