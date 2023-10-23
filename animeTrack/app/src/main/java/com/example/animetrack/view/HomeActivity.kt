package com.example.animetrack.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animetrack.R
import com.example.animetrack.databinding.HomeScreenBinding
import com.example.animetrack.model.User

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: HomeScreenBinding

    companion object {
        const val USER_INFO = "USER_INFO"
        fun start(context: Context, user: User) {
            val intent = Intent(context, HomeActivity::class.java).apply {
                putExtra(USER_INFO, user)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.getSerializableExtra(USER_INFO) as User
        binding.textView18.text = "Welcome, ${user.name}"
    }
}