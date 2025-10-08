package com.example.unimatch_frontend.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unimatch_frontend.views.Dashboard
import com.example.unimatch_frontend.views.Login


@Composable
fun Navigation(){
    val recordarPantalla = rememberNavController()

    NavHost(navController = recordarPantalla,
        startDestination = "V1") {

        composable ("V1"){ Login(recordarPantalla) }
        composable ("V2"){ Dashboard(recordarPantalla) }
    }

}