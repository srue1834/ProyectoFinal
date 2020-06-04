package com.example.proyectofinal.iniciar

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.FragmentIniciarBinding

/**
 * A simple [Fragment] subclass.
 */
class Iniciar : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentIniciarBinding>(
            inflater,
            R.layout.fragment_iniciar, container, false)

        //binding.siguiente4.setOnClickListener{
        //        view : View ->
        //    view.findNavController().navigate(R.id.action_iniciar_to_alarma)
        //}

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.navdrawer_menu, menu)

    }


}
