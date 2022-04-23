package cbass.monsterapp1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import cbass.monsterapp1.R
import cbass.monsterapp1.adapter.MonsterAdapter
import cbass.monsterapp1.databinding.FragmentListBinding
import cbass.monsterapp1.repository.MonsterRepo
import cbass.monsterapp1.viewmodel.MonsterVM


class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    val viewModel:MonsterVM by activityViewModels<MonsterVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater)
        viewModel.lista


        val adapter = MonsterAdapter()
        val layoutManager = LinearLayoutManager(requireContext())

        with(binding)
        {
            rvListaMonster.adapter = adapter
            rvListaMonster.layoutManager = layoutManager

            fbAdd.setOnClickListener {
                Navigation.findNavController(requireView()).navigate(R.id.action_listFragment_to_agregarFragment)
            }

            viewModel.lista.observe(viewLifecycleOwner, Observer {
                adapter.actualizar(it)
            })


        }



        return binding.root
    }
}