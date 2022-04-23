package cbass.monsterapp1.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import cbass.monsterapp1.R
import cbass.monsterapp1.databinding.FragmentAgregarBinding
import cbass.monsterapp1.model.Monster
import cbass.monsterapp1.viewmodel.MonsterVM

class AgregarFragment : Fragment() {

    lateinit var binding: FragmentAgregarBinding
    val viewModel: MonsterVM by activityViewModels<MonsterVM>()
    var idPic:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgregarBinding.inflate(layoutInflater)



        with(binding)
        {

            ib1.setOnClickListener {
                idPic = R.drawable.asset01
                ivPickedPick.setImageResource(idPic)

           }
            ib2.setOnClickListener {
                idPic = R.drawable.asset02
                ivPickedPick.setImageResource(idPic)
            }

            ib3.setOnClickListener {
                idPic = R.drawable.asset03
                ivPickedPick.setImageResource(idPic)
            }

            ib4.setOnClickListener {
                idPic = R.drawable.asset04
                ivPickedPick.setImageResource(idPic)
            }

            ib5.setOnClickListener {
                idPic = R.drawable.asset05
                ivPickedPick.setImageResource(idPic)
            }

            ib6.setOnClickListener {
                idPic = R.drawable.asset06
                ivPickedPick.setImageResource(idPic)
            }

            fbAddAdd.setOnClickListener {
                val imagen = idPic
                val nombre = etNom.text.toString()
                val intelligence = etInt.getText().toString().toInt()
                val fealdad = etFea.getText().toString().toInt()
                val maldad = etMal.getText().toString().toInt()
                val puntos = intelligence + fealdad + maldad
                val monster:Monster = Monster(imagen,nombre, intelligence, fealdad, maldad, puntos)
                viewModel.agregar(imagen,nombre, intelligence, fealdad, maldad, puntos)
                Log.i("monster",monster.toString())

                val alerta = AlertDialog.Builder(requireContext())
                alerta.setTitle("Agregado")
                alerta.setMessage("Monster agregado")
                alerta.setPositiveButton("Ok",DialogInterface.OnClickListener
                {
                    dialog, which -> dialog.cancel()
                })

                Navigation.findNavController(requireView()).navigate(R.id.action_agregarFragment_to_listFragment)



            }


        }

        return binding.root
    }

    private fun showList() {

    }

}