package com.example.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navController: NavHostController
){

    NavHost(navController = navController, startDestination = Screens.home.route){
        composable(
            route = Screens.home.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screens.drawer.route,
            arguments = listOf(
                navArgument(name = DETAIL_ARGUMENT_KEY){
                    type = NavType.StringType
                }
            )
        ){
            DrawerScreen(navController = navController, it.arguments)
        }
        composable(
            route = Screens.pokemon.route,
            arguments = listOf(
                navArgument(name = DETAIL_ARGUMENT_KEY2){
                    type = NavType.StringType
                }
            )
        ){
            PokemonSelected(navController = navController, argument = it.arguments)
        }
    }

}