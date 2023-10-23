package com.example.animetrack.model
import java.io.Serializable

data class User (
    val name: String = "",
    val password: String = ""
) : Serializable