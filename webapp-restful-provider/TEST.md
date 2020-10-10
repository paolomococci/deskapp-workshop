# Some tests:

```
$ curl -v -i http://127.0.0.1:8080/customers
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
< Date: Sat, 10 Oct 2020 08:09:50 GMT
Date: Sat, 10 Oct 2020 08:09:50 GMT

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
```

```
$ curl -v -i -H "Content-Type:application/json" -d '{"name":"John","surname":"Jumper","email":"johnjumper@example.local"}' http://127.0.0.1:8080/customers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /customers HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 69
> 
* upload completely sent off: 69 out of 69 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://127.0.0.1:8080/customers/5f816d8bfd149b2f6178ea82
Location: http://127.0.0.1:8080/customers/5f816d8bfd149b2f6178ea82
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sat, 10 Oct 2020 08:15:07 GMT
Date: Sat, 10 Oct 2020 08:15:07 GMT

< 
{
  "name" : "John",
  "surname" : "Jumper",
  "email" : "johnjumper@example.local",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/customers/5f816d8bfd149b2f6178ea82"
    },
    "customer" : {
      "href" : "http://127.0.0.1:8080/customers/5f816d8bfd149b2f6178ea82"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

```
$ curl -v -i -H "Content-Type:application/json" -d '{"name":"Emma","surname":"Jumper","email":"emmajumper@example.local"}' http://127.0.0.1:8080/customers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /customers HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 69
> 
* upload completely sent off: 69 out of 69 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://127.0.0.1:8080/customers/5f816ee4fd149b2f6178ea83
Location: http://127.0.0.1:8080/customers/5f816ee4fd149b2f6178ea83
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sat, 10 Oct 2020 08:20:52 GMT
Date: Sat, 10 Oct 2020 08:20:52 GMT

< 
{
  "name" : "Emma",
  "surname" : "Jumper",
  "email" : "emmajumper@example.local",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/customers/5f816ee4fd149b2f6178ea83"
    },
    "customer" : {
      "href" : "http://127.0.0.1:8080/customers/5f816ee4fd149b2f6178ea83"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

```
$ curl -v -i -H "Content-Type:application/json" -d '{"name":"Betty","surname":"Beginner","email":"bettybeginner@example.local"}' http://127.0.0.1:8080/customers
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /customers HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.58.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 75
> 
* upload completely sent off: 75 out of 75 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Vary: Origin
Vary: Origin
< Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
Vary: Access-Control-Request-Headers
< Location: http://127.0.0.1:8080/customers/5f816f9ffd149b2f6178ea84
Location: http://127.0.0.1:8080/customers/5f816f9ffd149b2f6178ea84
< Content-Type: application/hal+json
Content-Type: application/hal+json
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Sat, 10 Oct 2020 08:23:59 GMT
Date: Sat, 10 Oct 2020 08:23:59 GMT

< 
{
  "name" : "Betty",
  "surname" : "Beginner",
  "email" : "bettybeginner@example.local",
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/customers/5f816f9ffd149b2f6178ea84"
    },
    "customer" : {
      "href" : "http://127.0.0.1:8080/customers/5f816f9ffd149b2f6178ea84"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

```
$ curl -v -i http://127.0.0.1:8080/customers
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
< Date: Sat, 10 Oct 2020 08:24:25 GMT
Date: Sat, 10 Oct 2020 08:24:25 GMT

< 
{
  "_embedded" : {
    "customers" : [ {
      "name" : "John",
      "surname" : "Jumper",
      "email" : "johnjumper@example.local",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/customers/5f816d8bfd149b2f6178ea82"
        },
        "customer" : {
          "href" : "http://127.0.0.1:8080/customers/5f816d8bfd149b2f6178ea82"
        }
      }
    }, {
      "name" : "Emma",
      "surname" : "Jumper",
      "email" : "emmajumper@example.local",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/customers/5f816ee4fd149b2f6178ea83"
        },
        "customer" : {
          "href" : "http://127.0.0.1:8080/customers/5f816ee4fd149b2f6178ea83"
        }
      }
    }, {
      "name" : "Betty",
      "surname" : "Beginner",
      "email" : "bettybeginner@example.local",
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:8080/customers/5f816f9ffd149b2f6178ea84"
        },
        "customer" : {
          "href" : "http://127.0.0.1:8080/customers/5f816f9ffd149b2f6178ea84"
        }
      }
    } ]
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
    "totalElements" : 3,
    "totalPages" : 1,
    "number" : 0
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
