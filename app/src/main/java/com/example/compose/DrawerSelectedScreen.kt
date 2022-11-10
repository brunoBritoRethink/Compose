package com.example.compose

import android.os.Bundle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DrawerScreen( navController: NavController, arguments: Bundle? ){
    
    Text(text = arguments?.getString(DETAIL_ARGUMENT_KEY).toString())
    
}