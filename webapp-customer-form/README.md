# README

## Examining the following answer I decided to add some classes into the package model.
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
< Date: Tue, 13 Oct 2020 22:04:28 GMT
Date: Tue, 13 Oct 2020 22:04:28 GMT

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
