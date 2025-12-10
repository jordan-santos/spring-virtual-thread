# Spring Virtual Thread & Structured Concurrency PoC

![Java 21](https://img.shields.io/badge/Java-21-orange) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)

This project is a Proof of Concept (PoC) designed to test and demonstrate the behavior of **Java 21 Virtual Threads** and **Structured Concurrency** (`StructuredTaskScope`) when integrated with Spring Framework's resilience patterns, specifically **`@ConcurrencyLimit`**.

## 🎯 Objective

The main goal is to validate how concurrency limiting annotations behave when a single service method spawns multiple lightweight Virtual Threads. It serves as a practical example of the "Proxy Pitfall" in Spring AOP when dealing with internal parallelism.

## 🧠 Key Concepts

### 1. Virtual Threads (Project Loom)
Virtual threads are lightweight threads that dramatically reduce the effort of writing, maintaining, and observing high-throughput concurrent applications. Unlike platform threads (which are 1:1 with OS threads), virtual threads are managed by the JVM.

### 2. Structured Concurrency
Uses the `StructuredTaskScope` API to treat multiple tasks running in different threads as a single unit of work. This streamlines error handling and cancellation, ensuring that if one sub-task fails, the scope can automatically handle the cleanup of others.

### 3. @ConcurrencyLimit
An annotation (typically from Resilience4j or Spring Cloud Circuit Breaker) used to limit the number of concurrent executions of a specific method. It works via **Spring AOP (Aspect Oriented Programming)**.