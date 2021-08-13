# microservice-currency-exchange
A very basic microservice written in Spring boot.


# Spring Cloud Features Used
* Communication with other Microservices using Feign REST Client
* Implement client side load balancing with Ribbon
* Implement dynamic scaling using Eureka Naming Server and Ribbon
* Implement API Gateway with Zuul
* Implement Distributed tracing with Spring Cloud Sleuth and Zipkin
* Implement Fault Tolerance with Zipkin


# Ports
Application|Port
---------|---------
Limits Service|8080, 8081
Spring Cloud Config Server|8888
Currency Exchange Service|8000, 8001
Currency Conversion Service|8100, 8101
Netflix Eureka Naming Server|8080, 8081
Spring Cloud Config Server|8761
Netflix Zuul API Gateway Server|8765
