package com.example.animetrack.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import com.example.animetrack.databinding.CreateAccountBinding
import com.example.animetrack.model.User
import com.example.animetrack.utils.CredentialCheck

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var binding: CreateAccountBinding
    companion object {
        const val USERNAME = "CREATEACCOUNT_USERNAME"
        const val PASSWORD = "CREATEACCOUNT_PASSWORD"

        fun start(context: Context, responseLauncher: ActivityResultLauncher<Intent>) {
            val intent = Intent(context, CreateAccountActivity::class.java)
            responseLauncher.launch(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
    }

    private fun setUpListeners(){
        with(binding){
            btCreateAccount.setOnClickListener {
                val check = CredentialCheck.join(
                    etUsername.text.toString(),
                    etPassword.text.toString(),
                    etRepassword.text.toString()
                )
                if (check.fail) notifyInvalidCredentials(check.msg)
                else navigateToLoginActivity(User(etUsername.text.toString(), etPassword.text.toString()))
            }
        }
    }

    private fun navigateToLoginActivity(user: User) {
        val intent = Intent().apply {
            putExtra(USERNAME, user.name)
            putExtra(PASSWORD, user.password)
        }
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun notifyInvalidCredentials(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}