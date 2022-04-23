package cbass.monsterapp1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import cbass.monsterapp1.R
import cbass.monsterapp1.databinding.ItemLayoutBinding
import cbass.monsterapp1.model.Monster

class MonsterAdapter : RecyclerView.Adapter<MonsterAdapter.CustomViewHolder>() {
    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLayoutBinding.bind(itemView)

        fun bindData(monster: Monster)
        {
            with(binding)
            {
                tvNom.text = monster.nombre
                tvPoints.text = monster.puntos.toString()
                ivMonster.setImageResource(monster.imagen)


            }
        }

    }

    var lista:List<Monster> = ArrayList<Monster>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
       return lista.size
    }

    fun actualizar(list: List<Monster>)
    {
        this.lista = lista
        notifyDataSetChanged()
    }
}