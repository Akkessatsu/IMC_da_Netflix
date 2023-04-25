package com.example.imcdanetflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toolbar
import com.example.imcdanetflix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val signUpToolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.signup_toolbar)
        val appsRadicais: Button = findViewById(R.id.appsRadicais)
        val euclides: Button = findViewById(R.id.euclides)

        setSupportActionBar(signUpToolbar)
        supportActionBar?.title = null

        appsRadicais.setOnClickListener{
            goToIMC()
        }
        euclides.setOnClickListener {
            goToEuclides()
        }
    }
    private fun goToIMC() {
        val imc = Intent(this, IMC::class.java)
        startActivity(imc)
    }
    private fun goToEuclides() {
        val euclides = Intent(this, MDCDeEuclides::class.java)
        startActivity(euclides)
    }
}