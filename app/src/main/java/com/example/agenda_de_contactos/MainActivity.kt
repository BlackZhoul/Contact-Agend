package com.example.agenda_de_contactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.example.agenda_de_contactos.navigation.NavManager
import com.example.agenda_de_contactos.room.UsuariosDatabase
import com.example.agenda_de_contactos.ui.theme.Agenda_De_ContactosTheme
import com.example.agenda_de_contactos.viewmodels.UsuariosViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Agenda_De_ContactosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(this, UsuariosDatabase::class.java, "db_usuarios").build()
                    val dao = database.usuariosDao()
                    
                    val viewModel = UsuariosViewModel(dao)
                    
                    NavManager(viewModel = viewModel)
                }
            }
        }
    }
}

