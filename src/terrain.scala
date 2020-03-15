object Terrain (dimensions : Position) {
	val entities = new Array[Entity](position.x)(position.y)(position.z)
	val materials = new Array[Material](position.x)(position.y)(position.z)
}
