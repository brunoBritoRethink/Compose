package com.example.compose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose.model.info.InfoModel
import com.example.compose.model.info.InfoRepository

class InfoViewModel: ViewModel() {

    private var pokemon = MutableLiveData<InfoModel>()

    fun getSelectedPokemon(name: String): LiveData<InfoModel>{
        return InfoRepository().getInfoPokemons(name)
    }

}