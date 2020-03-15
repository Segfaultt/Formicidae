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
      // TODO - main loop here
    }
  }

  // fetches random enough number
  // doesn't have to be cryptographically random
  def getRand: Int = 5 // use get time

  def generateTerrain(seed: Int): Terrain = 
  {
    BattleGround.generateTerrain
  }
}
