package com.example.proyectofinal.fase1

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.FragmentFase1Binding

/**
 * A simple [Fragment] subclass.
 */
class Fase1 : Fragment() {

    private lateinit var fase1ViewModel: Fase1ViewModel
    private lateinit var binding: FragmentFase1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentFase1Binding>(
            inflater,
            R.layout.fragment_fase1, container, false)

        binding.siguiente.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_fase1_to_fase2)
        }

        binding.registrarse.setOnClickListener {
            val usuario = binding.usuario2.text.toString()
            val contra = binding.contra2.text.toString()

            fase1ViewModel.crearCuenta(usuario, contra)
        }

        binding.lifecycleOwner = this
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.navdrawer_menu, menu)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        fase1ViewModel = ViewModelProvider(this).get(Fase1ViewModel::class.java)
        binding.fase1ViewModel = fase1ViewModel


    }



}
