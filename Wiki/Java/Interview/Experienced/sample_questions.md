Java Developer Interview Questions for Experienced:

1.     You need to handle 1 million requests per second. How would you scale your backend architecture?
2.     If you are building an order management system, how would you design the services? (Database choices, API interactions, scalability)
3.     Design a simple service that asynchronously processes tasks using Spring Boot.
4.     You have a distributed system where one Microservice must call another but should retry on failure. How would you implement this in Spring Boot?
5.     You deployed a Spring Boot service, but it crashes with an "Out of Memory" error. How do you debug this?
6.     Your Spring Boot REST API, which fetches data from a database, suddenly becomes slow. The response time has increased from 100ms to 3 seconds.
7.     Your Spring Boot microservice is running on Kubernetes and after a few hours, it crashes with OutOfMemoryError.
·       What are the possible causes of memory leaks in Java?
·       How to find which objects are causing the memory leak?
·       How to use a profiler (like JVisualVM, YourKit) to detect leaks?

8.     One of your microservices has started consuming high CPU (90%), even though the incoming traffic is normal.
·       How to investigate and identify the root cause?
·       What could cause a thread to enter an infinite loop?
·        How can you profile CPU usage in a running application?

9.     You start your Spring Boot application, but it fails with a "BeanCurrentlyInCreationException" due to a circular dependency.
·       How to debug and fix this issue?
·       What Spring mechanisms help break circular dependencies?

10.  Your Spring Boot app occasionally freezes and stops processing requests.
·       How to detect a deadlock in Java?
·       How can you use jstack to diagnose the issue?
·       How can you avoid deadlocks in database transactions?
