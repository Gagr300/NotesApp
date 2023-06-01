package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.notesapp.databinding.ActivityLoginBinding
import com.example.notesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var username : EditText
    lateinit var password: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //getSupportActionBar()?.hide();

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener(View.OnClickListener {

            if (binding.username.text.toString().trim().isEmpty()){
                binding.username.error = "Enter username"
                // to select the field
                binding.username.requestFocus()
            }
            else if (binding.password.text.toString().trim().isEmpty()){
                    binding.password.error = "Enter password"
                    // to select the field
                    binding.password.requestFocus()
                }
            else {
                if (binding.username.text.toString().trim() == "user" && binding.password.text.toString().trim() == "1234"){
                    Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
                }

            }
        })
    }

}