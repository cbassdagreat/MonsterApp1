package cbass.monsterapp1.ui

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import cbass.monsterapp1.R
import cbass.monsterapp1.databinding.FragmentDetalleBinding
import cbass.monsterapp1.databinding.FragmentListBinding
import cbass.monsterapp1.model.Monster
import cbass.monsterapp1.viewmodel.MonsterVM


class DetalleFragment : Fragment() {

    lateinit var binding: FragmentDetalleBinding
    val viewModel: MonsterVM by activityViewModels()
    var idPic: Int = 0
    var monster = viewModel.monsterMutable.value

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetalleBinding.inflate(layoutInflater)

        with(binding)
        {
            tvFealDet.text = monster!!.fealdad.toString()
            tvIntDet.text = monster!!.intelligence.toString()
            tvMalDet.text = monster!!.maldad.toString()
            tvNombre.text = monster!!.nombre
            ivPickedPic.setImageResource(monster?.imagen!!)

            btnEditar.setOnClickListener{
                Navigation.findNavController(requireView()).navigate(R.id.action_detalleFragment_to_editarFragment)

            }

            btnVolverDetalle.setOnClickListener {
                Navigation.findNavController(requireView()).navigate(R.id.action_detalleFragment_to_listFragment)
            }
        }


        return binding.root
    }
}







