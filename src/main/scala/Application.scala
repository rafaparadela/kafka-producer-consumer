object Application extends App {

	def broker = "localhost:9092"
	def zookeeperConnect = "localhost:2181"

	override def main(args: Array[String]) = args.toList match {
		case "producer" :: topic :: amount :: Nil => runProducer(topic, amount.toInt)
		case "consumer" :: topic :: groupId :: Nil => runConsumer(topic, groupId)
		case _ => throw new Exception("Argument Error")
	}

	def runProducer(topic: String, amount: Int) = {
		val producer = new Producer(broker)

		(1 to amount).foreach(i => {
			producer.send(topic, s"Msg #$i")
			Thread.sleep(1000)
		})
	}

	def runConsumer(topic: String, groupId: String) = {
		val consumer = new Consumer(broker, topic, groupId, zookeeperConnect)
		consumer.run()
	}

}