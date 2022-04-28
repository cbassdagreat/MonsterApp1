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
import cbass.monsterapp1.databinding.FragmentEditarBinding
import cbass.monsterapp1.databinding.FragmentListBinding
import cbass.monsterapp1.model.Monster
import cbass.monsterapp1.viewmodel.MonsterVM


class EditarFragment : Fragment() {

    lateinit var binding: FragmentEditarBinding
    val viewModel: MonsterVM by activityViewModels()
    var idPic: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditarBinding.inflate(layoutInflater)

        with(binding)
        {
            ib1.setOnClickListener {
                idPic = R.drawable.asset01
                ivPickedPic.setImageResource(idPic)

            }
            ib2.setOnClickListener {
                idPic = R.drawable.asset02
                ivPickedPic.setImageResource(idPic)
            }

            ib3.setOnClickListener {
                idPic = R.drawable.asset03
                ivPickedPic.setImageResource(idPic)
            }

            ib4.setOnClickListener {
                idPic = R.drawable.asset04
                ivPickedPic.setImageResource(idPic)
            }

            ib5.setOnClickListener {
                idPic = R.drawable.asset05
                ivPickedPic.setImageResource(idPic)
            }

            ib6.setOnClickListener {
                idPic = R.drawable.asset06
                ivPickedPic.setImageResource(idPic)

            }

            viewModel.monsterMutable.observe(viewLifecycleOwner, Observer {
                binding.ivPickedPic.setImageResource(it.imagen!!)
                binding.etNom.text = it.nombre.toString().toEditable()
                binding.etFea.text = it.fealdad.toString().toEditable()
                //Log.i("fealdad", it.fealdad.toString())
                binding.etInt.text = it.intelligence.toString().toEditable()
                binding.etMal.text = it.maldad.toString().toEditable()
                binding.tvPointsEdit.text = it.puntos.toString()

            })

            btnEdit.setOnClickListener {

                var id = viewModel.monsterMutable.value!!.id

                val imagen = idPic
                val nombre = etNom.text.toString()
                val intelligence = etInt.getText().toString().toInt()
                val fealdad = etFea.getText().toString().toInt()
                val maldad = etMal.getText().toString().toInt()
                val puntos = intelligence + fealdad + maldad
                val monster: Monster = Monster(imagen,nombre, intelligence, fealdad, maldad, puntos)
                viewModel.actualizar(imagen,nombre, intelligence, fealdad, maldad, puntos, id)

                Navigation.findNavController(requireView()).navigate(R.id.action_editarFragment_to_listFragment)

            }

            btnVolver.setOnClickListener{
                Navigation.findNavController(requireView()).navigate(R.id.action_editarFragment_to_detalleFragment)
            }

        }




        return binding.root
    }

    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)
}



