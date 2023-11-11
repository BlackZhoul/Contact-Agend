package com.example.agenda_de_contactos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.agenda_de_contactos.viewmodels.UsuariosViewModel
import com.example.agenda_de_contactos.views.AgregarView
import com.example.agenda_de_contactos.views.EditarView
import com.example.agenda_de_contactos.views.InicioView

@Composable
fun NavManager(viewModel: UsuariosViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio" ) {
        composable("inicio") {
            InicioView(navController, viewModel)
        }

        composable("agregar") {
            AgregarView(navController, viewModel)
        }

        composable("editar/{id}/{usuario}/{email}", arguments = listOf(
            navArgument("id") {type = NavType.IntType },
            navArgument("usuario") {type = NavType.StringType },
            navArgument("email") {type = NavType.StringType }
        )) {
            EditarView(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("usuario"),
                it.arguments?.getString("email"),
                it.arguments?.getString("numero")
                )
        }
    }
}