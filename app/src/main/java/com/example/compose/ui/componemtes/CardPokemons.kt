package com.example.compose.ui.componemtes

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.compose.HomeScreenViewModel
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@SuppressLint("UnrememberedMutableState")
@Composable
fun CardPokemons(
    navController: NavController,
    viewModel: HomeScreenViewModel = viewModel()
) {

    val lista by viewModel.getPokemons().observeAsState()

    LazyColumn(
        modifier = Modifier.padding(top = 20.dp, bottom = 100.dp)
    ){
            items(lista?.results ?: mutableListOf()){ item ->
                CardCustom(navController = navController,nameItem = item.name, imageItem = item.url)
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun CardCustom(navController: NavController,nameItem: String, imageItem: String){

    var url = Uri.parse(imageItem)

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(route = "pokemon_screen/"+nameItem)
            }
    ) {
        Column() {
            Text(
                text = nameItem,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                modifier = Modifier.padding(8.dp)
            )
            /*GlideImage(
                imageModel = { imageItem }, // loading a network image using an URL.
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
            )*/
        }
    }
}