package com.example.compose

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PokemonSelected(navController: NavController, argument: Bundle?, viewModel: InfoViewModel = viewModel()){

    var info = viewModel.getSelectedPokemon(argument?.getString(DETAIL_ARGUMENT_KEY2).toString()).observeAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column() {
            Text(
                text = argument?.getString(DETAIL_ARGUMENT_KEY2).toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(text = info.value?.stats?.elementAt(0)?.base_stat.toString())
        }
    }
    
}