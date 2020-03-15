case class Position(var x: Int, var y: Int, var z: Int)
// 0 index ur position

trait Entity {
  def name: String
  def hp: Double
  def pos: Position
  def dmg: Double
  def speed: Double
}

trait Terrain {
  def dimensions: Position
  def entity(pos: Position): Entity
  def groundExist(pos: Position): Boolean
  def groundType(pos: Position): Material
  def generateTerrain(seed: Int): Unit
}

trait Material {
  def hardness: Int
  def output: Array[Material]
  def movementModifier(sp: Double): Double
}
