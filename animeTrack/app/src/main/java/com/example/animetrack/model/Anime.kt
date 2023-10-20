package com.example.animetrack.model

import java.io.Serializable

data class Anime(
    val title: String,
    val description: String,
    val year: String,
    val seasons: String,
    var isFavorite: Boolean,
    val genres: List<String> = emptyList(),
    val image: Int,
    val banner: Int,

) : Serializable
