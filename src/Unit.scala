case class Position(var x: Int, var y: Int, var z: Int)

trait Unit {
  def name: String
  def hp: Int
  def pos: Position

}
