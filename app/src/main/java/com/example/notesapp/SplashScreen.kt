package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAGS_CHANGED
        )

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,
                HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME)

    }
}