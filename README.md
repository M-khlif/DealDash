# Deal Dash

This project is a simple online shop backend built using a microservices architecture. The goal of this project is to
provide a scalable and reliable backend for an online shop.

<img src="https://github.com/M-khlif/DealDash/blob/main/Imgs/1.png?raw=true" style="width: 650px; max-width: 100%; height: auto" />

## Services

The project consists of the following services:

1. **Product Service**: This service is responsible for managing all the product-related operations such as adding new
   products, updating product details, and deleting products.

2. **Order Service**: This service handles all the order-related operations. It is responsible for creating new orders,
   updating order status, and deleting orders. It communicates synchronously with the Inventory Service and implements
   Resilience4j as a circuit breaker to prevent the system from being overwhelmed by requests. It also communicates
   asynchronously with the Notification Service using Kafka to send notifications when an order status changes.

3. **Inventory Service**: This service manages the inventory of the products. It keeps track of the stock levels of the
   products and updates them as orders are placed and fulfilled.

4. **Notification Service**: This service handles the notifications. It communicates asynchronously with the Order
   Service using Kafka and sends notifications to users when there are updates about their orders.
   <br><br>
   <img src="https://github.com/M-khlif/DealDash/blob/main/Imgs/6.png?raw=true" style="width: 650px; max-width: 100%; height: auto" />

## Architecture

The services communicate with each other as follows:

- The API Gateway communicates directly with the Product Service and the Order Service. It routes the requests from the
  clients to the appropriate services.

- The Order Service communicates synchronously with the Inventory Service and implements Resilience4j as a circuit
  breaker. This ensures that the Inventory Service does not get overwhelmed by requests and can continue to function
  even when the demand is high.

- The Order Service communicates asynchronously with the Notification Service. This is done using an event-driven
  architecture with Kafka. When an order status changes, the Order Service sends an event to Kafka, which is then picked
  up by the Notification Service and a notification is sent to the user.

## Technologies Used

- **Netflix Eureka**: Used as a discovery server. It allows the services to find each other without hardcoding their
  locations.<br><br>
    - **Registration**: When a microservice starts, it registers itself with the Eureka server.<br> This registration
      includes metadata about the service such as host, port, health indicator URL, home page, and other details.<br>
      The service ID is typically the name of the application. <br><br>
      <img src="https://github.com/M-khlif/DealDash/blob/main/Imgs/2.png?raw=true" style="width: 650px; max-width: 100%; height: auto" />
      <br><br>
    - **Service Discovery**: The Eureka Client fetches the service registry from the Eureka Server and caches it
      locally.<br>This local cache is then used to discover and invoke services.
      <br><br>
      <img src="https://github.com/M-khlif/DealDash/blob/main/Imgs/4.png?raw=true" style="width: 650px; max-width: 100%; height: auto" />
      <br><br>
    - **Client's local copy of service registry**: The Eureka Client fetches the service registry from the Eureka Server
      and caches it locally. <br> This local cache is updated periodically (every 30 seconds by default) from the
      server.
      <br><br>
      <img src="https://github.com/M-khlif/DealDash/blob/main/Imgs/5.png?raw=true" style="width: 650px; max-width: 100%; height: auto" />
      <br><br>
- **Spring Cloud Gateway**: Used as an API gateway. It provides a single entry point for the clients and routes their
  requests to the appropriate services.
  <br><br>

- **Keycloak**: Used as an auth server. It provides authentication and authorization services, ensuring that only
  authenticated and authorized users can access the services.
  <br><br>
  <img src="https://github.com/M-khlif/DealDash/blob/main/Imgs/7.png?raw=true" style="width: 650px; max-width: 100%; height: auto" />

## Setup and Installation

In progress...

## Usage

In progress...

## License

MIT License

Copyright (c) 2023 mk

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


