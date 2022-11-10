package com.example.compose.ui.componemtes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun NavigationBottom(navController: NavController){
    var selectedItem1 by remember { mutableStateOf(0) }
    val items1 = listOf("Songs", "Artists", "Playlists")

    Box(
        modifier = Modifier.fillMaxHeight()
    ) {
        NavigationBar(
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            items1.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                    label = { Text(item) },
                    selected = selectedItem1 == index,
                    modifier = Modifier.align(Alignment.Bottom),
                    onClick = { selectedItem1 = index }
                )
            }
        }
    }
}