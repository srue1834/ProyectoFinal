package com.example.proyectofinal.fase2

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.FragmentFase2Binding

/**
 * A simple [Fragment] subclass.
 */

class Fase2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentFase2Binding>(
            inflater,
            R.layout.fragment_fase2, container, false)

        binding.siguiente1.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_fase2_to_fase3)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.navdrawer_menu, menu)

    }

}
