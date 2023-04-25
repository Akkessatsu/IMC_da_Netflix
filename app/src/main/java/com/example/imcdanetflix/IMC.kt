package com.example.imcdanetflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imcdanetflix.databinding.ActivityImcBinding
import com.example.imcdanetflix.databinding.ActivityMainBinding

class IMC : AppCompatActivity() {

    private lateinit var binding: ActivityImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightPicker.minValue = 10
        binding.weightPicker.maxValue = 450

        binding.heightPicker.minValue = 100
        binding.heightPicker.maxValue = 300

        binding.weightPicker.setOnValueChangedListener{_, _, _ -> calculateBMI()}
        binding.heightPicker.setOnValueChangedListener{_, _, _ -> calculateBMI()}
    }

    private fun calculateBMI() {
        var height = binding.heightPicker.value
        val doubleHeight = height.toDouble() / 100

        val weight = binding.weightPicker.value

        val imc = weight.toDouble() / (doubleHeight * doubleHeight)

        binding.result.text = String.format("Seu IMC é: %.2f", imc)
        binding.healthy.text = String.format("Considerado: %s", healthyMessage(imc))

    }

    private fun healthyMessage(imc: Double): String {
        return  if (imc < 18.5)
            "Abaixo do peso"
        else if (imc < 25.0)
            "Saudável"
        else if (imc < 30.0)
            "Sobrepeso"
        else
            "Obeso"
    }
}