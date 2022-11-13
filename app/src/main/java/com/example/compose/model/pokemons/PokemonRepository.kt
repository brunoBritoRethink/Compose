package com.example.compose.model.pokemons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.compose.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRepository {

    var pokemonModel = MutableLiveData<PokemonModel>()

    fun getPokemons(auxOffSet: Int): LiveData<PokemonModel> {

        var retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service = retrofit.create(ApiService::class.java)
        var call: Call<PokemonModel> = service.nextPokemons(auxOffSet, 10)

        call.enqueue(object : Callback<PokemonModel> {
            override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
                pokemonModel.value = response.body()
            }
            override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
            }
        })
        return pokemonModel
    }
}