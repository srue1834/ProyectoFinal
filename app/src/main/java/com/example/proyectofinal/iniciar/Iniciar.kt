package com.example.proyectofinal.iniciar

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.FragmentIniciarBinding
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_fase1.*

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

        binding.signInButton.setOnClickListener {
            if (emailText.text.isNotEmpty() && passwordText.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailText.text.toString(),
                    passwordText.text.toString()).addOnCompleteListener {

                    if (it.isSuccessful){
                        goToMain()
                    }else {
                        mostrarError()
                    }

                }
            }
        }

        setHasOptionsMenu(false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.navdrawer_menu, menu)

    }

    private fun mostrarError()
    {
        val constructor = AlertDialog.Builder(activity)
        constructor.setTitle("Error")
        constructor.setMessage("Se ha producido un error al ingresar")
        constructor.setPositiveButton("Aceptar", null)
        val dialogo: AlertDialog = constructor.create()
        dialogo.show()
    }

    private fun goToMain(){
        view?.findNavController()?.navigate(R.id.action_iniciar_to_precios)
    }

}
