package dev.lucasmartins.pokedex.di

import dev.lucasmartins.pokedex.PokemonViewModel
import dev.lucasmartins.pokedex.network.pokemon.PokemonApiService
import dev.lucasmartins.pokedex.repository.PokemonRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { PokemonApiService() }
    single { PokemonRepository(get()) }
    viewModel { PokemonViewModel(get()) }
}