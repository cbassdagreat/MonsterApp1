package cbass.monsterapp1.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cbass.monsterapp1.dao.MonsterDao
import cbass.monsterapp1.model.Monster


@Database(entities = [Monster::class], version = 1)
abstract class ProjectDB : RoomDatabase() {

    abstract fun monsterDao(): MonsterDao

    companion object{
        @Volatile
        private var instancia:ProjectDB? = null

        fun getInstancia(context: Context) : ProjectDB
        {
            if (instancia == null)
            {
                synchronized(this)
                {
                    instancia = Room.databaseBuilder(context,ProjectDB::class.java,"project_db").build()
                }
            }
            return instancia!!
        }
    }

}