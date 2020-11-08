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
