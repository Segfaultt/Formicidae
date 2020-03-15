import Formicidae/src/entities._

class Footsoldier(startPos: Position, idInit: Int) extends Entity {
  private var health: Int = 10
  private var position: Position = startPos
  val id = idInit

  def name: String = "Footsoldier"
  def hp: Int = health

  def pos: Position = position

  def dmg: Int = 2
  def speed: Int = 5
}
