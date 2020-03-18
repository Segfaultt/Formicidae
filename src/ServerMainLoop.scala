import com._
import scala.collection.mutable.Queue
/*
 * TODO - figure out
 * Movement
 * Fog of war/what can be seen by both sides
 * Attack
 */


// this object should be called once per 'tick' to allow for updates to the map every fixed interval
object MainLoop {

	private val tick: Int = 500 // how long a 'tick' of the clock should be in ms
	private var te: Terrain = null // the terrain object that stores the state of the game
	private var moves: Transmitter = new Queue[Transmitter](5)
	
	def init: Unit = 
	{
	  val seed: Int = getRand
	  ter = generateTerrain(getRand)
	  
	}
	
        // Pre: transmitted moves are valid (aka not both fields null)
	def mainLoop: Unit = 
	{
		val toExec: Transmitter = getMove

                while(!toExec.isEmpty)
                {
                  val up: Transmitter = toExec.pop // up = updates
                  val tc: Array[(Position,Material)] = up.getTerrainChanges // tc = terrain changes
                  val ec: Array[(Position,Entity)] = up.getEntityChanges // ec = entity changes

                  if(null!=tc)
                    ter.updateTerrain(tc)
                  if(null!=ec)
                    ter.updateEntities(getMove.getEntityChanges)
                }
	}
	
	def getMove: Transmitter = 
	{
		val re: Queue[Transmitter] = moves
                moves = new Queue[Transmitter](5)
                re // stores in queue in case multiple transmitter objects received
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
