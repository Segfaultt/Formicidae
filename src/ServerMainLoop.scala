import traits._

/*
 * TODO - figure out
 * Movement
 * Fog of war/what can be seen by both sides
 * Attack
 */

object MainLoop {

	private val tick: Int = 500 // how long a 'tick' of the clock should be in ms
	private var te: Terrain = null // the terrain object that stores the state of the game
	private var moves: List[Move] = Nil
	
	def init: Unit = 
	{
	  val seed: Int = getRand
	  ter = generateTerrain(getRand)
	  
	}
	
	def mainLoop: Unit = 
	{
	  var quit: Boolean = false
	
	  while(!quit)
	  {
	    val todo: List[Move] = getMove
	  }
	}
	
	def getMove: List[Move] = 
	{
		val re: List[Move] = moves
		moves = Nil
		re
	}

	def addMove(x: Move): Unit = (moves = x::moves)
	
	// fetches random enough number
	// doesn't have to be cryptographically random
	def getRand: Int = 5 // use get time
	
	def generateTerrain(seed: Int): Terrain = 
	{
	  BattleGround.generateTerrain
	}
}
