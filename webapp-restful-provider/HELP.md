# webapp-restful-provider

## I try to use the service in this way:
```
$ curl -v -i http://127.0.0.1:8080
* Rebuilt URL to: http://127.0.0.1:8080/
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET / HTTP/1.1
> Host: 127.0.0.1:8080
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
< Date: Sat, 26 Sep 2020 05:22:05 GMT
Date: Sat, 26 Sep 2020 05:22:05 GMT

< 
{
  "_links" : {
    "customers" : {
      "href" : "http://127.0.0.1:8080/customers{?page,size,sort}",
      "templated" : true
    },
    "addresses" : {
      "href" : "http://127.0.0.1:8080/addresses{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

## Now I try to send a GET request to uri regarding documents customer:
```
paolo@gabriel:~$ curl -v -i http://127.0.0.1:8080/customers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /customers HTTP/1.1
> Host: 127.0.0.1:8080
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
< Date: Sat, 26 Sep 2020 05:22:24 GMT
Date: Sat, 26 Sep 2020 05:22:24 GMT

< 
{
  "_embedded" : {
    "customers" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/customers"
    },
    "profile" : {
      "href" : "http://127.0.0.1:8080/profile/customers"
    },
    "search" : {
      "href" : "http://127.0.0.1:8080/customers/search"
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
paolo@gabriel:~$ curl -v -i http://127.0.0.1:8080/profile/customers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /profile/customers HTTP/1.1
> Host: 127.0.0.1:8080
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
< Date: Sat, 26 Sep 2020 05:22:44 GMT
Date: Sat, 26 Sep 2020 05:22:44 GMT

< 
{
  "alps" : {
    "version" : "1.0",
    "descriptor" : [ {
      "id" : "customer-representation",
      "href" : "http://127.0.0.1:8080/profile/customers",
      "descriptor" : [ {
        "name" : "name",
        "type" : "SEMANTIC"
      }, {
        "name" : "surname",
        "type" : "SEMANTIC"
      }, {
        "name" : "email",
        "type" : "SEMANTIC"
      } ]
    }, {
      "id" : "get-customers",
      "name" : "customers",
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
      "rt" : "#customer-representation"
    }, {
      "id" : "create-customers",
      "name" : "customers",
      "type" : "UNSAFE",
      "descriptor" : [ ],
      "rt" : "#customer-representation"
    }, {
      "id" : "get-customer",
      "name" : "customer",
      "type" : "SAFE",
      "descriptor" : [ ],
      "rt" : "#customer-representation"
    }, {
      "id" : "patch-customer",
      "name" : "customer",
      "type" : "UNSAFE",
      "descriptor" : [ ],
      "rt" : "#customer-representation"
    }, {
      "id" : "update-customer",
      "name" : "customer",
      "type" : "IDEMPOTENT",
      "descriptor" : [ ],
      "rt" : "#customer-representation"
    }, {
      "id" : "delete-customer",
      "name" : "customer",
      "type" : "IDEMPOTENT",
      "descriptor" : [ ],
      "rt" : "#customer-representation"
    }, {
      "name" : "findByName",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "name",
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
      "name" : "findByEmail",
      "type" : "SAFE",
      "descriptor" : [ {
        "name" : "email",
        "type" : "SEMANTIC"
      } ]
    } ]
  }
* Connection #0 to host 127.0.0.1 left intact
}
$ curl -v -i http://127.0.0.1:8080/customers/search
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /customers/search HTTP/1.1
> Host: 127.0.0.1:8080
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
< Date: Sat, 26 Sep 2020 05:25:36 GMT
Date: Sat, 26 Sep 2020 05:25:36 GMT

< 
{
  "_links" : {
    "findByName" : {
      "href" : "http://127.0.0.1:8080/customers/search/findByName{?name}",
      "templated" : true
    },
    "findBySurname" : {
      "href" : "http://127.0.0.1:8080/customers/search/findBySurname{?surname}",
      "templated" : true
    },
    "findByEmail" : {
      "href" : "http://127.0.0.1:8080/customers/search/findByEmail{?email}",
      "templated" : true
    },
    "self" : {
      "href" : "http://127.0.0.1:8080/customers/search"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
