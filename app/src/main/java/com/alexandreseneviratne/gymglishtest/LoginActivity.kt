package com.alexandreseneviratne.gymglishtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        viewModel.getState().observe(this, Observer{ updateUI(it) })

        login_button.setOnClickListener {
            viewModel.login(edittext_username.text.toString(), edittext_password.text.toString())
            clearLoginUI()
        }
    }

    private fun updateUI(state: LoginState) {
        return when (state.authorizationStatus) {
            true -> {
                val intent = Intent(this, WebsiteListActivity::class.java)
                startActivity(intent)
            }
            false -> {
                Toast.makeText(this, state.errorMessage, Toast.LENGTH_SHORT).show()
                clearLoginUI()
            }
        }
    }

    private fun clearLoginUI() {
        edittext_username.text.clear()
        edittext_password.text.clear()
    }
}
