package cbass.monsterapp1.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cbass.monsterapp1.model.Monster
import cbass.monsterapp1.room.ProjectDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MonsterRepo (var context: Context){

    private val db = ProjectDB.getInstancia(context)
    fun agregar(monster: Monster)
    {
        CoroutineScope(Dispatchers.IO).launch {
            db.monsterDao().agregar(monster)
        }
    }

    fun listar(): LiveData<List<Monster>>
    {
        return db.monsterDao().listar()
    }

}