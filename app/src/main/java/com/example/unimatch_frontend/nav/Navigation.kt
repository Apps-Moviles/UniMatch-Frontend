package com.example.unimatch_frontend.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.unimatch_frontend.views.CompanyDescription
import com.example.unimatch_frontend.views.Dashboard
import com.example.unimatch_frontend.views.Login
import com.example.unimatch_frontend.views.Oportunities
import com.example.unimatch_frontend.views.Oportunity
import com.example.unimatch_frontend.views.Portfolio
import com.example.unimatch_frontend.views.PortfolioProyect
import com.example.unimatch_frontend.views.Reviews


@Composable
fun Navigation(){
    val recordarPantalla = rememberNavController()

    NavHost(navController = recordarPantalla,
        startDestination = "V1") {

        composable ("V1"){ Login(recordarPantalla) }
        composable ("V2"){ Dashboard(recordarPantalla) }
        composable ("Portfolio"){ Portfolio(recordarPantalla) }
        composable ("Opportunities"){ Oportunities(recordarPantalla) }
        composable ("Company/{index}/Reviews", arguments = listOf(navArgument("index"){ type = NavType.IntType})){
                backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0
            Reviews(recordarPantalla)
        }
        composable ("Company/{index}", arguments = listOf(navArgument("index"){ type = NavType.IntType})){
                backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0
            CompanyDescription(recordarPantalla)
        }
        composable ("Portfolio/{index}", arguments = listOf(navArgument("index"){ type = NavType.IntType})){
            backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0
            PortfolioProyect(recordarPantalla, index)
        }
        composable ("Opportunities/{index}", arguments = listOf(navArgument("index"){ type = NavType.IntType})){
                backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0
            Oportunity(recordarPantalla, index)
        }
    }

}