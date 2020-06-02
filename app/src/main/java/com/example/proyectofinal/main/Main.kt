package com.example.proyectofinal.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import com.example.proyectofinal.R

/**
 * A simple [Fragment] subclass.
 */
class Main : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)

        binding.iniciarB.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_registro)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)


    }
}
