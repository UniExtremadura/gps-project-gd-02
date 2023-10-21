package com.example.animetrack.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.AbsSavedState
import com.example.animetrack.R
import com.example.animetrack.databinding.LoginScreenBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}