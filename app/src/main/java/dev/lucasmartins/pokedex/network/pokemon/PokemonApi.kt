package dev.lucasmartins.pokedex.network.pokemon

import dev.lucasmartins.pokedex.network.pokemon.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon/{id}")
    suspend fun getPokemonData(@Path("id") id: Int): Response<PokemonResponse>
}
