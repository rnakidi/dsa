McDonald’s Reliable event-driven architecture

How events are reliably produced and consumed?

1. An event schema is defined and registered in the AWS ECS (schema registry)

2. Producer applications leverage Producer SDK to publish events

3. On application start up, event schema is cached in the producer application (performance improvement)

4. The SDK performs schema validation to ensure the event is as per the schema.

5. If the validation checks out, SDK publishes the event to the primary topic.

6. If the SDK encounters an error, such as schema validation or a retry able error, it is routed to the dead-letter topic tied to that producer

7. If the SDK encounters an error, such as MSK being unavailable, it is written to the DynamoDB database

8. Consumer applications leverage a consumer SDK

9. SDK similarly performs schema validation to ensure the events are consuming are as per the schema

10. A successful consumption results in a committing of the offset back to MSK and proceeds to consume the next event from the topic

11. Events within a dead-letter topic are later rectified through an admin utility and published back into the primary topic

12. Events produced by our partners, or “Outer Events,” are published via an event gateway


Over to you, what if producer buffers the events and dies before publishing?


# Reference and Image Credit

- medium .com/mcdonalds-technical-blog/behind-the-scenes-mcdonalds-event-driven-architecture-51a6542c0d86

- medium .com/mcdonalds-technical-blog/mcdonalds-event-driven-architecture-the-data-journey-and-how-it-works-4591d108821f

![image](https://github.com/user-attachments/assets/e185150f-27df-4d66-afee-47590a7f9d29)

Source/Credit: https://www.linkedin.com/posts/atechguide_systemdesign-architecture-activity-7288216598388084737-bRoh?utm_source=share&utm_medium=member_desktop

