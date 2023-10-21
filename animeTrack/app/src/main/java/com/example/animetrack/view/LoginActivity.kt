package com.example.animetrack.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animetrack.R

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}