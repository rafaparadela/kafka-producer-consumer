import java.util
import java.util.Properties
import org.apache.kafka.clients.consumer._
import org.apache.kafka.common.serialization.{StringDeserializer, IntegerDeserializer}
import scala.collection.JavaConversions._

class Consumer(brokerList: String, topic: String, groupId: String, zookeeperConnect: String) {

	private val props = new Properties()

	props.put("group.id", groupId)
	props.put("zookeeper.connect", zookeeperConnect)
	props.put("bootstrap.servers", brokerList)
	props.put("consumer.timeout.ms", "120000")
	props.put("auto.commit.interval.ms", "10000")

	def run() {
		val consumer = new KafkaConsumer[Integer, String](props, new IntegerDeserializer, new StringDeserializer)
		consumer.subscribe(util.Arrays.asList(topic))
		while (true) {
			consumer.poll(100).foreach(r => {
				println(s"GroupId: $groupId   - Key: ${r.key()}  - Value: ${r.value()}  - Offset: ${r.offset()}")
			})
		}
	}

}