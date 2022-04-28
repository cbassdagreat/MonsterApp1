package cbass.monsterapp1.ui

import android.os.Bundle
import android.text.Editable
import android.util.Log
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetalleBinding.inflate(layoutInflater)

        with(binding)
        {

            btnEditar.setOnClickListener{

                Navigation.findNavController(requireView()).navigate(R.id.action_detalleFragment_to_editarFragment)

            }

            btnVolverDetalle.setOnClickListener {
                Navigation.findNavController(requireView()).navigate(R.id.action_detalleFragment_to_listFragment)
            }
        }

        viewModel.monsterMutable.observe(viewLifecycleOwner, Observer {
            binding.ivPickedPic.setImageResource(it.imagen!!)
            binding.tvNombre.text = it.nombre.toString()
            binding.tvFealDet.text = it.fealdad.toString()
            Log.i("fealdad", it.fealdad.toString())
            binding.tvIntDet.text = it.intelligence.toString()
            binding.tvMalDet.text = it.maldad.toString()
            binding.tvPointsEdit.text = it.puntos.toString()

        })



        return binding.root
    }
}







