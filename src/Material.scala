import traits

/** material TODO:
  * - Implement randomness for drops
  */ 

object Stone extends Material {
	def id : Int = 0
	def hardness : Int = 10
	def output : Array[Material] = Array[Material](Stone)
	def movementModifier (sp : Double) : Double = sp*1.3
}

object Dirt extends Material {
	def id : Int = 1
	def hardness : Int = 5
	def output : Array[Material] = Array[Material](Dirt)
	def movementModifier (sp : Double) : Double = sp*0.8
}

object Air extends Material {
	def id : Int = 2
	def hardness : Int = 0
	def output : Array[Material] = null
	def movementModifier (sp : Double) : Double = sp*0
}

object Metal extends Material {
	def id : Int = 3
	def hardness : Int = 30
	def output : Array[Material] = Array[Material](Metal, Metal)
	def movementModifier (sp : Double) : Double = sp*0.7
}

object Coal extends Material {
	def id : Int = 4
	def hardness : Int = 9
	def output : Array[Material] = Array[Material](Coal, Coal)
	def movementModifier (sp : Double) : Double = sp*0.6
}
