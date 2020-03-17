import traits 

object BattleGround extends Terrain (dimensions : Position) {
	val entities = new Array[Entity](dimensions.x)(dimensions.y)(dimensions.z) 
        // implementation clear internally: DO NOT EXPOSE WITHOUT MAKING CLEAR
	val materials = new Array[Material](dimensions.x)(dimensions.y)(dimensions.z)

        def dimensions: Position = dimensions
        def entity(pos: Position): Entity = entities(pos.x)(pos.y)(pos.z)
        def groundExist(pos: Position): Boolean = materials(pos.x)(pos.y)(pos.z)
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

        def updateEntities(updates: Array[(Position,Entities)]: Unit = 
        {
          var apos: Int = 0
          val max: Int = updates.size

          while(apos<max)
          {
            val(gp,ent) = updates(apos)
            apos+=1
          }
        }
}
