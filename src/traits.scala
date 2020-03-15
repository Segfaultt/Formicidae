case class Position(var x: Int, var y: Int, var z: Int)
// 0 index ur position

trait Entity {
	def name: String
	def hp: Double
	def pos: Position
	def dmg: Double
	def speed: Double
	def inventory: Array[Material]
}

/*
 * Terrain should exist as this monolithic object storing:
 * Terrain material
 * Terrain size
 * Entities
 */

trait Terrain {
	def dimensions: Position
	def entity(pos: Position): Entity
	def moveEntity(origin: Position, end: Position): Boolean // true if move possible and complete otherwise false
	def groundExist(pos: Position): Boolean
	def groundType(pos: Position): Material
	def generateTerrain(seed: Int): Unit
}

trait Material {
	def hardness: Int
	def output: Array[Material]
	def movementModifier(sp: Double): Double
}
