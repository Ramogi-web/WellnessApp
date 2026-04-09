package com.example.wellnessapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 🔥  (animation)
        val logo = findViewById<ImageView>(R.id.logo)
        val animation = AnimationUtils.loadAnimation(this, R.anim.combo)
        logo.startAnimation(animation)
//        This activity is going to appear for like 5 sec then we are going to be taken to the main activity
        Handler().postDelayed(
            {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish() // prevents going back to splash
            }, 3000
        )


    }
}