# webapp-employee-restful-provider

## Examples of use:
```
$ curl -v -i http://127.0.0.1:8090/employees
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8090 (#0)
> GET /employees HTTP/1.1
> Host: 127.0.0.1:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Tue, 10 Nov 2020 07:41:28 GMT
Date: Tue, 10 Nov 2020 07:41:28 GMT

< 
{
  "_embedded" : {
    "employees" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8090/employees"
    },
    "profile" : {
      "href" : "http://127.0.0.1:8090/profile/employees"
    },
    "search" : {
      "href" : "http://127.0.0.1:8090/employees/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
```
$ curl -v -i http://127.0.0.1:8090/profile/employees
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8090 (#0)
> GET /profile/employees HTTP/1.1
> Host: 127.0.0.1:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/alps+json
Content-Type: application/alps+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Tue, 10 Nov 2020 07:42:12 GMT
Date: Tue, 10 Nov 2020 07:42:12 GMT

< 
{
  "alps" : {
    "version" : "1.0",
    "descriptor" : [ {
      "id" : "employee-representation",
      "href" : "http://127.0.0.1:8090/profile/employees",
      "descriptor" : [ {
        "name" : "name",
        "type" : "SEMANTIC"
      }, {
        "name" : "surname",
        "type" : "SEMANTIC"
      }, {
        "name" : "profession",
        "type" : "SEMANTIC"
      }, {
        "name" : "email",
        "type" : "SEMANTIC"
      } ]
    }, {
      "id" : "get-employees",
      "name" : "employees",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "page",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The page to return."
        }
      }, {
        "name" : "size",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The size of the page to return."
        }
      }, {
        "name" : "sort",
        "type" : "SEMANTIC",
        "doc" : {
          "format" : "TEXT",
          "value" : "The sorting criteria to use to calculate the content of the page."
        }
      } ],
      "rt" : "#employee-representation"
    }, {
      "id" : "create-employees",
      "name" : "employees",
      "type" : "UNSAFE",
      "descriptor" : [ ],
      "rt" : "#employee-representation"
    }, {
      "id" : "get-employee",
      "name" : "employee",
      "type" : "SAFE",
      "descriptor" : [ ],
      "rt" : "#employee-representation"
    }, {
      "id" : "delete-employee",
      "name" : "employee",
      "type" : "IDEMPOTENT",
      "descriptor" : [ ],
      "rt" : "#employee-representation"
    }, {
      "id" : "update-employee",
      "name" : "employee",
      "type" : "IDEMPOTENT",
      "descriptor" : [ ],
      "rt" : "#employee-representation"
    }, {
      "id" : "patch-employee",
      "name" : "employee",
      "type" : "UNSAFE",
      "descriptor" : [ ],
      "rt" : "#employee-representation"
    }, {
      "name" : "findByProfession",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "profession",
        "type" : "SEMANTIC"
      } ]
    }, {
      "name" : "findByEmail",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "email",
        "type" : "SEMANTIC"
      } ]
    }, {
      "name" : "findBySurname",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "surname",
        "type" : "SEMANTIC"
      } ]
    }, {
      "name" : "findByName",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "name",
        "type" : "SEMANTIC"
      } ]
    } ]
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
```
$ curl -v -i http://127.0.0.1:8090/employees/search
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8090 (#0)
> GET /employees/search HTTP/1.1
> Host: 127.0.0.1:8090
> User-Agent: curl/7.58.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Tue, 10 Nov 2020 07:46:38 GMT
Date: Tue, 10 Nov 2020 07:46:38 GMT

< 
{
  "_links" : {
    "findByProfession" : {
      "href" : "http://127.0.0.1:8090/employees/search/findByProfession{?profession}",
      "templated" : true
    },
    "findByEmail" : {
      "href" : "http://127.0.0.1:8090/employees/search/findByEmail{?email}",
      "templated" : true
    },
    "findBySurname" : {
      "href" : "http://127.0.0.1:8090/employees/search/findBySurname{?surname}",
      "templated" : true
    },
    "findByName" : {
      "href" : "http://127.0.0.1:8090/employees/search/findByName{?name}",
      "templated" : true
    },
    "self" : {
      "href" : "http://127.0.0.1:8090/employees/search"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
