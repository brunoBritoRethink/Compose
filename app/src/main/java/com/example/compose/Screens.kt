package com.example.compose

const val DETAIL_ARGUMENT_KEY = "name"
const val DETAIL_ARGUMENT_KEY2 = "pokemon"

sealed class Screens(val route: String){

    object home: Screens("home_screen")
    object drawer: Screens("drawer_screen/{$DETAIL_ARGUMENT_KEY}")
    object pokemon: Screens("pokemon_screen/{$DETAIL_ARGUMENT_KEY2}")

}
