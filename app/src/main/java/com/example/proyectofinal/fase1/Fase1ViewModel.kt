package com.example.proyectofinal.fase1

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.proyectofinal.database.Repositorio
import com.example.proyectofinal.database.UsuariosDatabase

class Fase1ViewModel(context: Context) : ViewModel() {
    private val repositorio: Repositorio

    init {
        repositorio = Repositorio.getInstancia(UsuariosDatabase.getDatabase(context).UsuariosDao())
    }
    internal fun crearCuenta(usuario: String, contra: String) {
        repositorio.ingresar_usuario(usuario, contra)
    }
    internal fun cuentaValida(usuario: String, contra: String): Boolean {
        return repositorio.valida(usuario, contra)

    }

    class Factory internal constructor(contexto: Context) : ViewModelProvider.Factory {
        private val contexto: Context

        init {
            this.contexto = contexto.applicationContext
        }

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            TODO("Not yet implemented")
            return Fase1ViewModel(contexto) as T
        }
    }
}