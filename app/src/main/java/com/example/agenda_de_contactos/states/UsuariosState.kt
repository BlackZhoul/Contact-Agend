package com.example.agenda_de_contactos.states

import com.example.agenda_de_contactos.models.Usuarios

data class UsuariosState(
    val listaUsuarios: List<Usuarios> = emptyList()
)
