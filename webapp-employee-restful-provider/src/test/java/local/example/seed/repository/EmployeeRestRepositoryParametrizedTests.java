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
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRestRepositoryParametrizedTests {

    @Autowired
    MockMvc mockMvc;

    private static final AtomicReference<String> EMPLOYEE_TEST_STRING;
    private static URI uri;

    static {
        EMPLOYEE_TEST_STRING = new AtomicReference<>(
                "{\"name\":\"John\",\"surname\":\"Jump\",\"profession\":\"bender\",\"email\":\"johnjump@example.local\"}"
        );
    }

    @Test
    @Order(1)
    void createTest() throws Exception {
        MvcResult mvcResult = this.mockMvc
                .perform(post("/employees").content(EMPLOYEE_TEST_STRING.get()))
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
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.surname").value("Jump"))
                .andExpect(jsonPath("$.profession").value("bender"))
                .andExpect(jsonPath("$.email").value("johnjump@example.local"));
    }

    @Order(3)
    @ParameterizedTest
    @MethodSource("initUri")
    void readAllTest() throws Exception {
        this.mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded").exists());
    }

    @Order(4)
    @ParameterizedTest
    @MethodSource("initUri")
    void updateTest() throws Exception {
        EMPLOYEE_TEST_STRING.set(
                "{\"name\":\"James\",\"surname\":\"Painter\",\"profession\":\"driver\",\"email\":\"jamespainter@example.local\"}"
        );
        this.mockMvc.perform(put(getUri())
                .content(EMPLOYEE_TEST_STRING.get()))
                .andExpect(status().isNoContent());
        this.mockMvc.perform(get(getUri()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("James"))
                .andExpect(jsonPath("$.surname").value("Painter"))
                .andExpect(jsonPath("$.profession").value("driver"))
                .andExpect(jsonPath("$.email").value("jamespainter@example.local"));
    }

    @Order(5)
    @ParameterizedTest
    @MethodSource("initUri")
    void partialUpdateTest() throws Exception {
        this.mockMvc.perform(patch(getUri())
                .content("{\"email\":\"james.painter@example.local\"}"))
                .andExpect(status().isNoContent());
        this.mockMvc.perform(get(getUri()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("james.painter@example.local"));
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
        EmployeeRestRepositoryParametrizedTests.uri = uri;
    }

    private static URI getUri() {
        return uri;
    }

    private static Stream<String> initUri() {
        return Stream.of(
                EmployeeRestRepositoryParametrizedTests.getUri().getPath()
        );
    }
}
