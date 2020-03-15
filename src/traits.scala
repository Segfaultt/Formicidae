case class Position(var x: Int, var y: Int, var z: Int)
// 0 index ur position
case class Move(var entity: Entity, var target: Entity, var pos: Position, var finalPos: Position)

//type Action = TODO - figure out how to enumerate different interactions with the world

trait Entity {
	def name: String
	def hp: Double
	def pos: Position
	def dmg: Double
	def speed: Double
	def inventory: Array[Material]
	val id: Int
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
        def updateTerrain(Array[(Position,Material)]): Unit
        def updateEntities(Array[(Position,Entity)]): Unit
	def generateTerrain(seed: Int): Unit
}

trait Material {
	def hardness: Int
	def output: Array[Material]
	def movementModifier(sp: Double): Double
}

trait Transmitter {
	def terrainChange(Array[(Position, Material)]): Unit
        def getTerrainChanges: Array[(Position,Material)]
	def entityChange(Array[(Position,Entity)]): Unit
        def getEntityChanges: Array[(Position,Entity)]
}
