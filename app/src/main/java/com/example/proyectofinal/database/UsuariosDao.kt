package com.example.proyectofinal.database

import com.example.proyectofinal.database.Usuarios
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuariosDao{
    @Insert
    fun insert(usuario: Usuarios)

    @Query("SELECT * FROM usuarios_table WHERE usuarios_table.usuarioId LIKE :usuario")
    fun getUsuario(usuario: String): Usuarios

}