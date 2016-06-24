# kafka-producer-consumer

Minimal implementation of Kafka client 0.9 producer & consumer.

### Quick Start:

You should now have Kafka 0.9 running at `localhost:9092` and zookeeper running at `localhost:2181`.

##### Run a producer:

`sbt "run producer my-topic 50"` will send `50` messages (1 per second) with the topic `my-topic`. 

##### Run consumers:

`sbt "run consumer my-topic my-group-id"` will subscribe to the topic `my-topic` using the groupId `my-group-id`.

