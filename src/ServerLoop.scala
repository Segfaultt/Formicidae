//import scala.collection.mutable.Queue
import Transmitter._

/*
 * TODO - figure out
 * Movement
 * Fog of war/what can be seen by both sides
 * Attack
 */

class ServerLoop {

	private val tickLength: Int = 500 // how long a 'tick' of the clock should be in ms
	private var ter: Terrain = new Battleground(Position(1000,1000,3)) // the terrain object that stores the state of the game
	
	def init: Unit = 
	{
		val seed: Int = System.currentTimeMillis().toInt
		ter.generateTerrain(seed)
	}
	
	def tick: Unit = 
	{
		/*val toExec: Transmitter = getMove//??? Transmitter is a singleton object
                ter.updateTerrain(getMove.getTerrainChanges)
                ter.updateEntities(getMove.getEntityChanges)*/
	}
	
	/*def getMove: Transmitter = 
	{
		val re: Transmitter = moves//??? 
		moves = new Queue()
		re
	}*/

	//def addMove(x: Transmitter): Unit = (moves.enqueue(x))
}
