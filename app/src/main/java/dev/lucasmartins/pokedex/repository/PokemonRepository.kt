package dev.lucasmartins.pokedex.repository

import dev.lucasmartins.pokedex.model.Pokemon
import dev.lucasmartins.pokedex.network.pokemon.PokemonApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepository(
    private val pokemonApiService: PokemonApiService
) {
    suspend fun getPokemonData(id: Int): Pokemon? = withContext(Dispatchers.IO) {
        val response = pokemonApiService.getPokemonData(id)
        val pokemon = response.body()
        return@withContext if(response.isSuccessful && pokemon != null) {
            Pokemon(pokemon.name, pokemon.sprites.frontDefault)
        } else {
            null
        }
    }
}