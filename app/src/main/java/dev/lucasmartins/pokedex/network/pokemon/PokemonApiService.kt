package dev.lucasmartins.pokedex.network.pokemon

import dev.lucasmartins.pokedex.network.pokemon.model.PokemonResponse
import dev.lucasmartins.pokedex.network.util.RetrofitUtil
import retrofit2.Response

class PokemonApiService(
    private val api: PokemonApi = RetrofitUtil.getApiService(BASE_URL, PokemonApi::class.java)
) {
    suspend fun getPokemonData(id: Int): Response<PokemonResponse> {
        return api.getPokemonData(id)
    }

    companion object {
        private const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}