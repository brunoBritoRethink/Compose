package com.example.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.compose.model.pokemons.PokemonModel
import com.example.compose.model.pokemons.PokemonRepository

class HomeScreenViewModel: ViewModel() {

    var lista by mutableStateOf(PokemonModel(results = mutableListOf()))

    fun getPokemons(): LiveData<PokemonModel> {
        return PokemonRepository().getPokemons(10)
    }

}