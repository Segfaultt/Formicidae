import Formicidae/src/entities._

class Footsoldier(startPos: Position) extends Entity {
  private var health: Int = 10
  private var position: Position = startPos

  def name: String = "Footsoldier"
  def hp: Int = health

  def pos: Position = position

  def dmg: Int = 2
  def speed: Int = 5
}
