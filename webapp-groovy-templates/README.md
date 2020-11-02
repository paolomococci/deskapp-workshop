# webapp-groovy-templates

## Here's what this web application does
This demo directly accesses the data stored in the NoSQL database, instead of using the RESTful API.

## To fix the message: "illegal reflexive access", you need to add the following line to the build.gradle file:
```
	implementation 'org.codehaus.groovy:groovy:3.0.6'
```
