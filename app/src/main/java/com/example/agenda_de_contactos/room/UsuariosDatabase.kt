package com.example.agenda_de_contactos.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.agenda_de_contactos.models.Usuarios

@Database(
    entities = [Usuarios::class],
    version = 1,
    exportSchema = false
)
abstract class UsuariosDatabase: RoomDatabase() {
    abstract fun usuariosDao(): UsuariosDatabaseDao
}