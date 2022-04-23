package cbass.monsterapp1.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import cbass.monsterapp1.model.Monster

@Dao
interface MonsterDao {

    @Insert(onConflict =REPLACE)
    fun agregar(monster: Monster)

    @Query("select id,image,name,puntos from monster_table")
    fun listar() : LiveData<List<Monster>>
}