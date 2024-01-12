# Project Overview

This repository showcases the architecture and design principles behind our project, leveraging various Angular stones and Online Platform Building tools. The system is built on solid foundations such as Integral Structure (DDD), Domain Driven Design (DDD), Saga/Patterns processes (SAGA), and Cross Platform Interfaces Event & Event Sourcing (CPI).
### System Architecture

The system architecture is a crucial aspect of our project, defining how various services collaborate to process orders seamlessly. The diagram in the center of the image illustrates the key components and their interactions. Here's a step-by-step breakdown of the order processing flow:

#### 1. User Interaction via HTTP API

The journey begins as the user interacts with the system through the **HTTP API**. This interface is the entry point for placing orders and initiating the order processing workflow.

#### 2. Order Service

The user's request is then handed off to the **Order Service**, a central component responsible for processing orders. This service is pivotal in orchestrating the entire order fulfillment process.

#### 3. Kafka Message Broker

To facilitate asynchronous communication and decouple services, the **Order Service** interacts with **Kafka**, a powerful message broker. Kafka ensures reliable and scalable messaging, allowing seamless communication between different services.

#### 4. Service Interactions via Kafka

Kafka sends messages to various services, each handling a specific aspect of the order processing:

   - **Payment Service:** Manages payment processing, ensuring secure and efficient transactions.
   - **Restaurant Service:** Receives order details and manages the fulfillment process through Restaurant Logic.
   - **Dashboard Service:** Updates the dashboard in real-time, providing users with up-to-date information on order status and other details.

#### 5. Payment Processing

The **Payment Service** processes payments securely, ensuring a smooth financial transaction as part of the order fulfillment process.

#### 6. Restaurant Logic

The **Restaurant Service** receives order details and utilizes Restaurant Logic to handle the fulfillment process. This involves coordinating with the kitchen, managing inventory, and ensuring timely delivery.

#### 7. Real-time Dashboard Updates

Simultaneously, the **Dashboard Service** updates in real-time, reflecting the latest order status and relevant details. This provides users with a comprehensive view of the order processing pipeline.

This orchestrated flow, illustrated by the numbered arrows in the diagram, showcases the seamless collaboration of services to fulfill user orders efficiently.

### Explore the Code

Dive into our codebase to gain a deeper understanding of how these architectural components are implemented. Each service plays a crucial role in contributing to the overall success of the system.

## Diagram
![Overview Project Diagram](https://github.com/emgs0/food-ordering-system/blob/master/Overview%20Food%20Ordering%20System.drawio.png)
### Domain Driven Design (DDD)
At the heart of our project lies Domain Driven Design (DDD), a methodology that emphasizes a deep understanding of the domain to guide the development process. The following key concepts are integral to our implementation:

#### 1. Aggregates

In DDD, aggregates are clusters of entities and value objects that are treated as a single unit. They ensure consistency and encapsulation within a specific boundary. By defining clear aggregates, we enhance the structure of our domain model and promote maintainability.

#### 2. Domain Events

Domain events are occurrences of significance within the system. In our project, these events emanate from a single root and trigger reactions across the system. By leveraging domain events, we achieve loose coupling between components and facilitate a more event-driven architecture.

#### 3. Consistency Boundary

Consistency boundaries define the scope within which data consistency is guaranteed. It helps in managing complexity by containing changes and ensuring that related data is always in a consistent state. This concept is crucial for maintaining integrity within specific sections of the domain.

#### 4. Eventual Consistency

In a distributed system like ours, achieving immediate consistency across all components might be impractical. Eventual consistency acknowledges this reality and allows for discrepancies that will eventually be reconciled. It is particularly useful in scenarios where quick responses and scalability are essential.

#### 5. Command Handler

Commands represent intentions to change the state of the system. The command handler is responsible for interpreting these commands and executing the corresponding actions. This separation of concerns contributes to a clean and modular architecture, aligning with the principles of DDD.

The diagram presented here represents a software architecture deeply rooted in Domain-Driven Design (DDD), an approach that fosters collaboration between domain experts and software developers. This structure is designed to encapsulate various aspects of an order processing system.

## Diagram Overview
<p align="center">
  <img src="https://github.com/emgs0/food-ordering-system/blob/master/dependency-graph.png" />
</p>

### Components Breakdown

The structure comprises several interconnected components, each serving a specific purpose within the domain-driven architecture:

#### 1. order-container

The **order-container** stands as the central entity, likely representing the main application or service orchestrating the entire system. It serves as the hub for various modules and components, facilitating their collaboration.

#### 2. order-application

The **order-application** module is responsible for handling application logic and user interface concerns. It serves as a layer that translates user interactions into meaningful actions within the system, bridging the gap between the user interface and the underlying business logic.

#### 3. order-dataaccess

The **order-dataaccess** module is dedicated to data persistence tasks, including interactions with databases. It encapsulates the mechanisms for storing and retrieving data, ensuring the integrity and availability of essential information.

#### 4. order-messaging

The **order-messaging** module manages communication with other services or components. This could involve handling messages through queues or event streams, enabling seamless interaction between different parts of the system.

#### 5. order-application-service

The **order-application-service** acts as a connecting layer, interfacing between the application logic and the domain core. It likely contains services that leverage the application logic to interact with the heart of the system, the **order-domain-core**.

#### 6. order-domain-core

At the heart of the system lies the **order-domain-core**, which houses the business logic and business rules. This component embodies the essence of DDD, encapsulating domain-specific knowledge and ensuring that the system's behavior aligns with the requirements and expectations of the business domain.

## Order Service Detail (Microservice Architectural Comparison Layered vs Hexagonal)

### Overview

This diagram presents a comparative analysis between two architectural patterns for an "Order Service" microservice: **Layered Architecture (traditional)** and **Hexagonal Architecture (Clean Architecture)**.

### Diagram

![Architecture Diagram](https://github.com/emgs0/food-ordering-system/blob/master/Order%20Service%20Detail.drawio.png)

### Hexagonal Architecture Highlights

- **Flexibility:** Hexagonal Architecture is more flexible and easily testable.
- **Dependency Inversion:** Utilizes Dependency Inversion and polymorphism (DIP), enhancing adaptability for complex systems.
- **Isolation:** Components are independent and stable, enabling development and testing in isolation.
- **Dependency Injection (DI):** Connects components, reducing tight coupling and enhancing modularity.

### Layered Architecture Insights

- **Linear Dependency Chain:** Traditional Layered Architecture has a linear dependency chain, making it less flexible and harder to test.
- **Advantages of Dependency Inversion:** Hexagonal Architecture allows for easy replacement of DBMS or external services without affecting other layers. It enhances testability and adaptability for different communication protocols.

### Sumary Clean Code
Hexagonal Architecture proves to be a more adaptable and test-friendly choice, especially for complex systems. The inversion of dependencies, coupled with modular design principles, offers significant advantages over the more rigid Layered Architecture.

## Order Service Domain Logic

This section unveils the intricacies of the Order Service Domain Logic through a detailed diagram. The architecture aligns with the principles of Domain-Driven Design (DDD), emphasizing a deep understanding of the domain to guide the development of the Order Service.

### Diagram Overview

![Order Service Domain Logic](https://github.com/emgs0/food-ordering-system/blob/master/Order%20Service%20Domain%20Logic.drawio.png)

### Key Elements

The diagram revolves around three main Aggregate Roots, each representing a cohesive cluster of entities: **Order Processing Aggregate**, **Restaurant Aggregate**, and **Customer Aggregate**.

#### 1. Order Processing Aggregate

The central focus of the diagram, the **Order Processing Aggregate**, encapsulates the order-related domain logic. Key entities within this aggregate include:

   - **Order:** Represents an order placed by a customer, with attributes such as orderId, orderStatus, and more.
   - **Order Items:** Details the products included in the order, including attributes like name, price, and quantity.
   - **Products:** Representing the items available for order, each with its specific details.

   The **Order Processing Aggregate** progresses through various states and events, such as ordered and paid, which are crucial for tracking the order processing workflow.

#### 2. Restaurant Aggregate

The **Restaurant Aggregate** is linked to the products available for order. It includes entities such as:

   - **Restaurant:** Represents a specific establishment providing products for order.

   The **Restaurant Aggregate** interacts with products, ensuring a seamless connection between the available items and the associated restaurants.

#### 3. Customer Aggregate

The **Customer Aggregate** represents customer-related data and is intricately connected to orders. The entities within this aggregate include:

   - **Customer:** Represents customer information, including attributes like customerId and address.

### Value Objects and Domain Events

On the left side of the diagram, a list of **Value Objects** is outlined, including orderId, customerId, address, ITEMID, RestaurantId, etc. These value objects play a crucial role in defining attributes within the entities.

Below the value objects, a list of **Domain Events** is presented, featuring events like orderCreatedEvent. These events signify different stages or actions within the order processing workflow, providing a clear representation of the system's dynamics.

## Explore the Diagram

Delve into the diagram to gain a visual understanding of how these elements interact. Each entity, value object, and domain event is meticulously designed to capture the essence of the Order Service Domain Logic, providing a solid foundation for building a robust and efficient system.
