package com.example.animetrack.model

import com.example.animetrack.model.Anime
class Lista  {

    private val Animes: List<Anime> = emptyList()

    fun addAnime(anime: Anime) {
        Animes.plus(anime)
    }

    fun removeAnime(anime: Anime) {
        Animes.minus(anime)
    }

    fun getAnime(index: Int): Anime {
        return Animes[index]
    }

    fun getAnimes(): List<Anime> {
        return Animes
    }

    fun size(): Int {
        return Animes.size
    }

    fun isEmpty(): Boolean {
        return Animes.isEmpty()
    }

    fun contains(anime: Anime): Boolean {
        return Animes.contains(anime)
    }

    fun indexOf(anime: Anime): Int {
        return Animes.indexOf(anime)
    }
}