package cbass.monsterapp1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "monster_table")
class Monster(

    @ColumnInfo(name = "image")
    var imagen:Int?,
    @ColumnInfo(name = "name")
    var nombre:String?,
    @ColumnInfo(name = "intel")
    var intelligence:Int?,
    @ColumnInfo (name = "fea")
    var fealdad:Int?,
    @ColumnInfo (name = "mal")
    var maldad:Int?,
    @ColumnInfo (name = "puntos")
    var puntos:Int?,
    @ColumnInfo(name = "id")
@PrimaryKey(autoGenerate = true)
var id:Int=0

)