/*

package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notesapp.databinding.ActivityLoginBinding
import com.example.notesapp.databinding.ActivityMainBinding

class ActivityLogin : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding.btnLogin.setOnClickListener {
            val username = binding.txtUsername.text.toString().trim()
            val password = binding.txtPassword.text.toString().trim()
            if (username.isEmpty()){
                binding.txtUsername.error = "Enter username"
                // to select the field
                binding.txtUsername.requestFocus()
            }
            else if (password.isEmpty()){
                binding.txtPassword.error = "Enter password"
                binding.txtPassword.requestFocus()
            }
            else {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

*/
