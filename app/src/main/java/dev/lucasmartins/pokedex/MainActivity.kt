package dev.lucasmartins.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.lucasmartins.pokedex.ui.theme.PokedexTheme
import dev.lucasmartins.pokedex.ui.widgets.PokemonCard
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Pokemon()
                }
            }
        }
    }
}

@Composable
fun Pokemon(
    pokemonViewModel: PokemonViewModel = getViewModel()
) {
    val pokemonList by pokemonViewModel.getPokemon(1..100).collectAsState(initial = listOf())

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(pokemonList, key = { it.name }) {
            PokemonCard(pokemon = it)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexTheme {
        Pokemon()
    }
}