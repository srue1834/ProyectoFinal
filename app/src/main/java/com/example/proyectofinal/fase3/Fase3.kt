package com.example.proyectofinal.fase3

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import com.example.proyectofinal.R

/**
 * A simple [Fragment] subclass.
 */
class Fase3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentRegistroBinding>(
            inflater,
            R.layout.fragment_registro, container, false)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.registrados_menu, menu)

    }

}
