import MainLoop._

object Server {
	def main(args : Array[String]) : Unit = 
	{
		if (args.size < 1) {
			println("Please provide the number of players with the first argument.")
		} else {
			val nPlayers = args(1).toInt
			print("Starting Formi server with " + nPlayers.toString + " players.")
			val gameloop = new MainLoop
			gameloop.init
			print(".")

			print(".")
		}
	}
}
