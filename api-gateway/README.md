# API-Gateway

The API Gateway is a critical component in the Supermarket microservices architecture, serving as the central entry point for external clients. It is responsible for intelligently routing and managing requests, providing a unified interface to interact with various services.

## Key Features

- **Routing**: Efficiently directs incoming requests to the appropriate microservice based on the request path.
- **Security**: Enforces authentication, authorization, and implements rate limiting to safeguard the system.
- **Aggregation**: Composes responses from multiple microservices to fulfill complex client requests seamlessly.

## Configuration

The API Gateway's behavior and routes are configured through the centralized Config Server. Here's an example configuration snippet:

port: 8222

routes:
- id: auth-service
  uri: http://localhost:8090
  predicates:
    - Path=/auth/**
  filters:
    - AuthenticationFilter



- id: inventory-service
  uri: http://localhost:8092
  predicates:
    - Path=/api/v1/inventory/**
  filters:
    - AuthenticationFilter