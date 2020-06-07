package com.example.proyectofinal.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class UsuariosDatabase : RoomDatabase(){
    abstract fun UsuariosDao(): UsuariosDao

    companion object{
        private var INSTANCE: UsuariosDatabase? = null

        fun getDatabase(context: Context): UsuariosDatabase{
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    UsuariosDatabase::class.java, "usuario_database"
                ).allowMainThreadQueries().build()

            }

            return INSTANCE!!
        }

        fun destruir(){
            INSTANCE = null
        }
    }
}