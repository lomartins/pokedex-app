package dev.lucasmartins.pokedex.network.pokemon.model

import com.google.gson.annotations.SerializedName

data class SpriteResponse(
    @SerializedName("front_default")
    val frontDefault: String
)
