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

import axios from 'axios';

const EMPLOYEE_API_BASE_URI = "http://localhost:8090/employees";


export default class EmployeeRetrieveService {

    create(employee) {
        return axios.post(EMPLOYEE_API_BASE_URI, employee);
    }

    read(id) {
        return axios.get(EMPLOYEE_API_BASE_URI + '/' + id);
    }

    readAll() {
        return axios.get(EMPLOYEE_API_BASE_URI);
    }

    update(employee, id) {
        return axios.put(EMPLOYEE_API_BASE_URI + '/' + id, employee);
    }

    delete(id) {
        return axios.delete(EMPLOYEE_API_BASE_URI + '/' + id);
    }
}
