package com.example.proyectofinal.fase1

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.proyectofinal.R
import com.example.proyectofinal.databinding.FragmentFase1Binding
import com.example.proyectofinal.databinding.FragmentMainBinding
import com.example.proyectofinal.fase2.ProviderType
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_fase1.*

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
        val binding = DataBindingUtil.inflate<FragmentFase1Binding>(inflater,
            R.layout.fragment_fase1, container, false)

        /*binding.siguiente.setOnClickListener{
                view : View ->
            view.findNavController().navigate(R.id.action_fase1_to_fase2)
        }

        binding.registrarse.setOnClickListener {
            val usuario = binding.email.text.toString()
            val contra = binding.password.text.toString()

            fase1ViewModel.crearCuenta(usuario, contra)
        }*/

        binding.signUpButton.setOnClickListener {
            if (emailText.text.isNotEmpty() && passwordText.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword( emailText.text.toString(),
                    passwordText.text.toString()).addOnCompleteListener {

                    if (it.isSuccessful){
                        goToFase2()
                    }else {
                        mostrarError()
                    }

                }
            }
        }

        binding.lifecycleOwner = this
        setHasOptionsMenu(false)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.navdrawer_menu, menu)

    }

    private fun goToFase2(){
        view?.findNavController()?.navigate(R.id.action_fase1_to_fase2)
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        fase1ViewModel = ViewModelProvider(this).get(Fase1ViewModel::class.java)
        binding.fase1ViewModel = fase1ViewModel


    }*/

    private fun setup()
    {
        /*binding.registrarse.setOnClickListener{
            if(usuario2.text.isNotEmpty() && correo.text.isNotEmpty() &&
                contra2.text.isNotEmpty()
                && confirmar.text.isNotEmpty())
            {
                FirebaseAuth.getInstance()

                    .createUserWithEmailAndPassword(usuario2.text.toString(),
                        correo.text.toString())
                    .addOnCompleteListener{
                        if(it.isSuccessful){
//register(it.result?.user?.email?: "")
                            Toast.makeText(activity, "Autenticación Correcta", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            mostrarError()
                        }
                    }
            }
        }*/
    }

    private fun mostrarError()
    {
        val constructor = AlertDialog.Builder(activity)
        constructor.setTitle("Error")
        constructor.setMessage("Se ha producido un error en el registro de usuario")
        constructor.setPositiveButton("Aceptar", null)
        val dialogo: AlertDialog = constructor.create()
        dialogo.show()
    }


/*private fun register(user: String/*, email: String*/)
{
val constructor = AlertDialog.Builder(context)
constructor.setTitle("¡Perfecto!")
constructor.setMessage("Se he registrado correctamente")
constructor.setPositiveButton("Aceptar", null)
val dialogo: AlertDialog = constructor.create()
dialogo.show()
}*/

}
