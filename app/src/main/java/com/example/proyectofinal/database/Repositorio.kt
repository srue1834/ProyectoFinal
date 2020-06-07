package com.example.proyectofinal.database

import androidx.lifecycle.LiveData

class Repositorio private constructor(private val usuariosDao: UsuariosDao) {
    private val usuarios_liveData: LiveData<Usuarios>? = null

    fun valida(usuario: String, contra: String): Boolean {
        val usuarios =usuariosDao.getUsuario(usuario)
        return  usuarios.contra == contra
    }
    fun ingresar_usuario(usuario: String, contra: String) {
        val cuenta = Usuarios(usuario, contra)
        usuariosDao.insert((cuenta))
    }
    companion object{
        private var instancia: Repositorio? = null

        fun getInstancia(usuariosDao: UsuariosDao): Repositorio{
            if(instancia == null) {
                instancia = Repositorio(usuariosDao)
            }
            return instancia!!
        }
    }
}