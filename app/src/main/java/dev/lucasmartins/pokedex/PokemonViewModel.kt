package dev.lucasmartins.pokedex

import androidx.lifecycle.ViewModel
import dev.lucasmartins.pokedex.model.Pokemon
import dev.lucasmartins.pokedex.repository.PokemonRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.net.UnknownHostException

class PokemonViewModel(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {
    fun getPokemon(range: IntRange) = flow {
        val pokemonList = mutableListOf<Pokemon>()
        try {
            for (i in range) {
                pokemonRepository.getPokemonData(i).collect {
                    it?.let {
                        pokemonList.add(it)
                        emit(pokemonList.toMutableList())
                    }
                }
            }
        } catch (e: Exception) {

        }
    }
}