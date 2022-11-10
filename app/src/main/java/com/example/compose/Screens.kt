package com.example.compose

const val DETAIL_ARGUMENT_KEY = "name"

sealed class Screens(val route: String){

    object home: Screens("home_screen")
    object drawer: Screens("drawer_screen/{$DETAIL_ARGUMENT_KEY}")

}
