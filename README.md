# kafka-producer-consumer

Minimal implementation of Kafka client 0.9 producer & consumer.

### Quick Start:

You should now have Kafka 0.9 running at `localhost:9092` and zookeeper running at `localhost:2181`.`

##### Run a producer:

`sbt "run producer my-topic 50"` where `my-topic` is the topic, and `50` is the number of messages delivered (1 per second). 

##### Run consumers:

`sbt "run consumer my-topic my-group-id"` where `my-topic` is the topic, and `my-group-id` is the groupId. 