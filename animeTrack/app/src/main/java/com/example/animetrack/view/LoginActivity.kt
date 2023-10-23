package com.example.animetrack.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.AbsSavedState
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.preference.PreferenceManager
import com.example.animetrack.R
import com.example.animetrack.databinding.LoginScreenBinding
import com.example.animetrack.model.User
import com.example.animetrack.utils.CredentialCheck

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginScreenBinding

    private val responseLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                with(result.data) {
                    val name = this?.getStringExtra(CreateAccountActivity.USERNAME).orEmpty()
                    val password = this?.getStringExtra(CreateAccountActivity.PASSWORD).orEmpty()

                    with(binding) {
                        etPassword.setText(password)
                        etUsername.setText(name)
                    }

                    Toast.makeText(
                        this@LoginActivity,
                        "New user ($name/$password) created",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            else Toast.makeText(this, "User creation cancelled", Toast.LENGTH_SHORT).show()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
        readSettings()
    }

    private fun setUpListeners() {
        with(binding) {
            btLogin.setOnClickListener {
                val check = CredentialCheck.login(etUsername.text.toString(), etPassword.text.toString())
                if (check.fail) notifyInvalidCredentials(check.msg)
                else navigateToHomeActivity(User(etUsername.text.toString()), check.msg)
            }

            btCreateAccount.setOnClickListener {
                navigateToCreateAccount()
            }
        }
    }

    private fun readSettings(){
        val preferences = PreferenceManager.getDefaultSharedPreferences(this).all

        val rememberme = preferences["rememberme"] as Boolean? ?: false // Settings de la aplicación (no un check)
        val username = preferences["username"] as String? ?: ""
        val password = preferences["password"] as String? ?: ""

        if (rememberme) {
            binding.etUsername.setText(username)
            binding.etPassword.setText(password)
        }
    }

    private fun navigateToHomeActivity(user: User, msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        HomeActivity.start(this, user)
    }

    private fun navigateToCreateAccount() {
        CreateAccountActivity.start(this, responseLauncher)
    }

    private fun notifyInvalidCredentials(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}