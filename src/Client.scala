object Client {
	def main(args : Array[String]) = 
	{
		Receiver.init(4276)
		Transmitter.init(4277)

		Transmitter.connectToServer(args(0))

		Receiver.close
		Transmitter.close
	}
}
