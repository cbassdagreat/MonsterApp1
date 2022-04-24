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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetalleBinding.inflate(layoutInflater)

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

            fbAddAdd.setOnClickListener {

                val imagen = idPic
                val nombre = etNom.text.toString()
                val intelligence = etInt.getText().toString().toInt()
                val fealdad = etFea.getText().toString().toInt()
                val maldad = etMal.getText().toString().toInt()
                val puntos = intelligence + fealdad + maldad
                //val monster: Monster = Monster(imagen,nombre, intelligence, fealdad, maldad, puntos)
                viewModel.actualizar(imagen,nombre, intelligence, fealdad, maldad, puntos)

                Navigation.findNavController(requireView()).navigate(R.id.action_detalleFragment_to_listFragment)

            }

        }

            viewModel.monsterMutable.observe(viewLifecycleOwner, Observer {
                binding.ivPickedPic.setImageResource(it.imagen!!)
                binding.etNom.text = Editable.Factory().newEditable(it.nombre.toString())
                binding.etFea.text = Editable.Factory().newEditable(it.fealdad.toString())
                binding.etInt.text = Editable.Factory().newEditable(it.intelligence.toString())
                binding.etMal.text = Editable.Factory().newEditable(it.maldad.toString())
                binding.tvPointsEdit.text = it.puntos.toString()

            })



        return binding.root
        }
    }



