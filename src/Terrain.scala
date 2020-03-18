import com._

object BattleGround extends Terrain {
	private val entities = Array.ofDim[Entity](dimensions.x,dimensions.y,dimensions.z) 
        // implementation clear internally: DO NOT EXPOSE WITHOUT MAKING CLEAR
	private val materials = Array.ofDim[Material](dimensions.x,dimensions.y,dimensions.z)
        private var dim: Position = null

        def init(dimensions: Position): Unit = 
        {
          dim = dimensions
        }

        def dimensions: Position = dim
        def entity(pos: Position): Entity = entities(pos.x)(pos.y)(pos.z)
        def groundExist(pos: Position): Boolean = null != materials(pos.x)(pos.y)(pos.z)
        // null used to represent no terrain
        def groundType(pos: Position): Material = materials(pos.x)(pos.y)(pos.z)

        def updateTerrain(updates: Array[(Position,Material)]): Unit = 
        {
          var apos: Int = 0
          val max: Int = updates.size

          while(apos<max)
          {
            val(gp,mat) = updates(apos) // gp = grid pos
            materials(gp.x)(gp.y)(gp.z) = mat
            apos+=1
          }
        }

        def updateEntities(updates: Array[(Position,Entity)]): Unit = 
        {
          var apos: Int = 0
          val max: Int = updates.size

          while(apos<max)
          {
            val(gp,ent) = updates(apos)
            apos+=1
          }
        }

        private def getEnt(pos: Position): Entity = entities(pos.x)(pos.y)(pos.z)
        private def setEnt(pos: Position, ent: Entity): Unit = entities(pos.x)(pos.y)(pos.z) = ent

        def moveEntity(origin: Position, end: Position): Unit = 
        {
          setEnt(end,getEnt(origin))
        }

        def generateTerrain(seed: Int): Unit = ??? // TODO - implement initial terrain generation
}
