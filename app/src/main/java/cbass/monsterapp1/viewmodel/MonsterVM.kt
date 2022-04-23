package cbass.monsterapp1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cbass.monsterapp1.model.Monster
import cbass.monsterapp1.repository.MonsterRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MonsterVM (application: Application):AndroidViewModel(application){

    private val repo = MonsterRepo(application.applicationContext)
    val lista : LiveData<List<Monster>> = repo.listar()

    fun agregar(imagen:Int,nombre:String,intelligence:Int,fealdad:Int,maldad:Int,puntos:Int)
    {
        val m = Monster(imagen, nombre, intelligence, fealdad, maldad, puntos)
        repo.agregar(m)
    }

}