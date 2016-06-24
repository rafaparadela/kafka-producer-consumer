import java.util.{UUID, Properties}
import org.apache.kafka.clients.producer._

class Producer(brokerList: String) {

	private val props = new Properties()

	props.put("client.id", UUID.randomUUID().toString)
	props.put("bootstrap.servers", brokerList)
	props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer")
	props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

	val p = new KafkaProducer[Integer, String](props)

	def send(topic: String, message: String): Unit = {
		println(s"Sending message: $message to topic $topic")
		p.send(new ProducerRecord[Integer, String](topic, message))
	}

}