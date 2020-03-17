class FootSoldier(startPos: Position, idInit: Int) extends Entity {
	private var health: Double = 10
	private var position: Position = startPos
	val id = idInit

	def name: String = "Footsoldier"
	def hp: Double = health

	def pos: Position = position

	def dmg: Double = 2
	def speed: Double = 5

	def inventory: Array[Material] = ???
}
