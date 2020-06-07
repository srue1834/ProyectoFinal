package com.example.proyectofinal.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios_table")
data class Usuarios(@PrimaryKey var usuarioId: String,
                    @ColumnInfo(name = "contra") var contra: String)
