package com.example.practica1_interfazusuario2.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica1_interfazusuario2.databinding.ActivitySplashBinding
import com.example.practica1_interfazusuario2.ui.main.MainActivity
import java.util.*
import kotlin.concurrent.timerTask

private lateinit var splashBinding: ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(view)

        val timer = Timer()
        timer.schedule(
            timerTask{
                goToMainActivity()
            }, 1000
        )
    }

    private fun goToMainActivity() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}