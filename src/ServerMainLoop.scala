import traits._
import scala.collection.mutable.Queue
/*
 * TODO - figure out
 * Movement
 * Fog of war/what can be seen by both sides
 * Attack
 */

object MainLoop {

	private val tick: Int = 500 // how long a 'tick' of the clock should be in ms
	private var ter: Terrain = new BattleGround // the terrain object that stores the state of the game
	
	def init: Unit = 
	{
	  val seed: Int = getRand
	  ter.generateTerrain(getRand)
	  
	}
	
	def mainLoop: Unit = 
	{
		val toExec: Transmitter = getMove//??? Transmitter is a singleton object
                ter.updateTerrain(getMove.getTerrainChanges)
                ter.updateEntities(getMove.getEntityChanges)
	}
	
	def getMove: Transmitter = 
	{
		val re: Transmitter = moves//??? 
		moves = new Queue()
		re
	}

	def addMove(x: Transmitter): Unit = (moves.enqueue(x))
	
	// fetches random enough number
	// doesn't have to be cryptographically random
	def getRand: Int = 5 // use get time
	
	def generateTerrain(seed: Int): Terrain = 
	{
	  BattleGround.generateTerrain
	}
}
