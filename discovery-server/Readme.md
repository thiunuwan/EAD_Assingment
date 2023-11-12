# Discovery Microservice

Discovery Server a.k.a. Eureka Server is an application that holds the information about all client-service applications. Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address.

## Overview

A Discovery Server acts as a central hub that keeps track of all the available services in a distributed system. Microservices register themselves with the Discovery Server upon startup, providing information about their location and availability. Other microservices can then query the Discovery Server to dynamically discover and communicate with these registered services.

## Features

- **Service Registration** Microservices register themselves with the Discovery Server, providing metadata such as host, port, and health status.
- **Service Discovery** Enables dynamic discovery of services within the system. Microservices can query the Discovery Server to obtain information about other services they need to communicate with.
- **Load Balancing** Many Discovery Servers incorporate load balancing mechanisms. This ensures that incoming requests are distributed across multiple instances of a service, optimizing resource usage and improving system performance.

