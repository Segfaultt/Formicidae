import traits._

/*
 * TODO - figure out
 * Movement
 * Fog of war/what can be seen by both sides
 * Attack
 */

object MainLoop {

  private val tick: Int = 500 // how long a 'tick' of the clock should be
  private val te: Terrain = null

  def init: Unit = 
  {
    val seed: Int = getRand
    ter = generateTerrain(getRand)
  }

  // fetches random enough number
  // doesn't have to be cryptographically random
  def getRand: Int = 5 // use get time


  def generateTerrain(seed: Int): Terrain = 
  {
    BattleGround.generateTerrain
  }
}
