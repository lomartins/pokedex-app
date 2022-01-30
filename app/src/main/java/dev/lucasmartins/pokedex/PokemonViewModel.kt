package dev.lucasmartins.pokedex

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.lucasmartins.pokedex.model.Pokemon
import dev.lucasmartins.pokedex.repository.PokemonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonViewModel(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {
    private val _pokemonLiveData = MutableLiveData<List<Pokemon>>()
    private val scope = CoroutineScope(Dispatchers.Unconfined)

    val pokemonLiveData: LiveData<List<Pokemon>> = _pokemonLiveData

    fun loadPokemon(range: IntRange) {
        val pokemonList = mutableListOf<Pokemon>()
        scope.launch {
            for (i in range) {
                try {
                    pokemonRepository.getPokemonData(i)?.let {
                        pokemonList.add(it)
                        withContext(Dispatchers.Main) {
                            _pokemonLiveData.value = pokemonList.toList()
                        }
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "loadPokemon: ", e)
                }
            }
        }
    }

    companion object {
        const val TAG = "PokemonViewModel"
    }
}