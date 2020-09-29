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

package local.example.seed.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.net.URI;
import java.util.Objects;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddressRestRepositoryParametrizedTests {

    @Autowired
    MockMvc mockMvc;

    private static final String ADDRESS_TEST_STRING =
            "{\"country\":\"Italy\",\"city\":\"Rome\",\"street\":\"some\",\"civic\":\"123\",\"code\":\"054321\"}";
    private static URI uri;

    @Test
    @Order(1)
    void createTest() throws Exception {
        MvcResult mvcResult = this.mockMvc
                .perform(post("/addresses").content(ADDRESS_TEST_STRING))
                .andExpect(status().isCreated())
                .andReturn();
        setUri(new URI(
                Objects.requireNonNull(mvcResult.getResponse().getHeader("Location"))
        ));
    }

    @Order(2)
    @ParameterizedTest
    @MethodSource("initUri")
    void readTest() throws Exception {
        this.mockMvc.perform(get(getUri()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.country").value("Italy"))
                .andExpect(jsonPath("$.city").value("Rome"))
                .andExpect(jsonPath("$.street").value("some"))
                .andExpect(jsonPath("$.civic").value("123"))
                .andExpect(jsonPath("$.code").value("054321"));
    }

    @Order(3)
    @ParameterizedTest
    @MethodSource("initUri")
    void readAllTest() throws Exception {
        this.mockMvc.perform(get("/addresses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded").exists());
    }

    @Order(4)
    @ParameterizedTest
    @MethodSource("initUri")
    void updateTest() throws Exception {
        this.mockMvc.perform(put(getUri())
                .content("{\"country\":\"Italy\",\"city\":\"Milan\",\"street\":\"millennium\",\"civic\":\"321\",\"code\":\"012345\"}"))
                .andExpect(status().isNoContent());
        this.mockMvc.perform(get(getUri()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.country").value("Italy"))
                .andExpect(jsonPath("$.city").value("Milan"))
                .andExpect(jsonPath("$.street").value("millennium"))
                .andExpect(jsonPath("$.civic").value("321"))
                .andExpect(jsonPath("$.code").value("012345"));
    }

    @Order(5)
    @ParameterizedTest
    @MethodSource("initUri")
    void partialUpdateTest() throws Exception {
        this.mockMvc.perform(patch(getUri())
                .content("{\"name\":\"Twenty-First\"}"))
                .andExpect(status().isNoContent());
        this.mockMvc.perform(get(getUri()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.country").value("Italy"));
    }

    @Order(6)
    @ParameterizedTest
    @MethodSource("initUri")
    void deleteTest() throws Exception {
        this.mockMvc.perform(delete(getUri()))
                .andExpect(status().isNoContent());
    }

    @Order(7)
    @ParameterizedTest
    @MethodSource("initUri")
    void notFoundTest() throws Exception {
        this.mockMvc.perform(get(getUri()))
                .andExpect(status().isNotFound());
    }

    private static void setUri(URI uri) {
        AddressRestRepositoryParametrizedTests.uri = uri;
    }

    private static URI getUri() {
        return uri;
    }

    private static Stream<String> initUri() {
        return Stream.of(
                AddressRestRepositoryParametrizedTests.getUri().getPath()
        );
    }
}
