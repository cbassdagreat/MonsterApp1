package cbass.monsterapp1.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import cbass.monsterapp1.model.Monster

@Dao
interface MonsterDao {

    @Insert(onConflict =REPLACE)
    fun agregar(monster: Monster)

    @Delete()
    fun eliminar(monster: Monster)

    @Update
    fun actualizar(monster: Monster)

    @Query("select id,image,name,puntos from monster_table")
    fun listar() : LiveData<List<Monster>>
}