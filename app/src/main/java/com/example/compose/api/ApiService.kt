package com.example.compose.api

import com.example.compose.model.info.InfoModel
import com.example.compose.model.pokemons.PokemonModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("pokemon/{selected}")
    fun getSelectedPokemon(@Path("selected") selectedPokemon: String): Call<InfoModel>

    @GET("pokemon")
    fun nextPokemons(
        @Query("offset") offSetPokemon: Int,
        @Query("limit") limitPokemon: Int
    ): Call<PokemonModel>

}