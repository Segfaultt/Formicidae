object Server {
	def main(args : Array[String]) : Unit = 
	{
		if (args.size < 1) {
			println("Please provide the number of players with the first argument.")
		} else {
			val nPlayers = args(0).toInt
			println("Starting Formi server with " + nPlayers.toString + " players.")
			Receiver.init(4277)
			Transmitter.init(4276)
			var i = 0 
			for (i <- 0 until nPlayers) Receiver.listenForNewClient

			val gameloop = new ServerLoop
			gameloop.init
		}

		Receiver.close
		Transmitter.close
	}
}
