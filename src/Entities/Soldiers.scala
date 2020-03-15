import /entities._

class Footsoldier(pos: Position) extends Entity {
  private var health: Int = 10
  private var position: Position = (0,0,0)

  def name: String = "Footsoldier"
  def hp: Int = health

  def pos

  def dmg: Int = 2
  def speed: Int = 5
}
