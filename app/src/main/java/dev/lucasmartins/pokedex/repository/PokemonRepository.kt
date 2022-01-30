package dev.lucasmartins.pokedex.repository

import dev.lucasmartins.pokedex.model.Pokemon
import dev.lucasmartins.pokedex.network.pokemon.PokemonApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PokemonRepository(
    private val pokemonApiService: PokemonApiService
) {
    suspend fun getPokemonData(id: Int): Flow<Pokemon?> = flow {
        val response = pokemonApiService.getPokemonData(id)
        val pokemon = response.body()
        if(response.isSuccessful && pokemon != null) {
            emit(Pokemon(pokemon.name, pokemon.sprites.frontDefault))
        } else {
            emit(null)
        }
    }.flowOn(Dispatchers.IO)
}