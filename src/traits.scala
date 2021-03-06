case class Position(var x: Int, var y: Int, var z: Int)
// 0 index ur position
case class Move(var entity: Entity, var target: Entity, var pos: Position, var finalPos: Position)

//type Action = TODO - figure out how to enumerate different interactions with the world

trait Entity {
	val id: Int
	def name: String
	def hp: Double
	def pos: Position
	def dmg: Double
	def speed: Double
	def inventory: Array[Material]

	//check numerical identity
	override def equals(that : Any) : Boolean = {
		that match {
			case that : Entity => id == that.id
			case _ => false
		}
	}
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
        def updateTerrain(changes: Array[(Position,Material)]): Unit
        def updateEntities(changes: Array[(Position,Entity)]): Unit
	def generateTerrain(seed: Int): Unit
}

trait Material {
	def id: Int
	def hardness: Int
	def output: Array[Material]
	def movementModifier(sp: Double): Double
	
	//check qualitative identity 
	override def equals(that : Any) : Boolean = {
		that match {
			case that : Material => id == that.id
			case _ => false
		}
	}
}
