package com.example.imcdanetflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imcdanetflix.databinding.ActivityImcBinding
import com.example.imcdanetflix.databinding.ActivityMdcdeEuclidesBinding

class MDCDeEuclides : AppCompatActivity() {

    private lateinit var binding: ActivityMdcdeEuclidesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMdcdeEuclidesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstNumber.minValue = 0
        binding.firstNumber.maxValue = 10000

        binding.secondNumber.minValue = 1
        binding.secondNumber.maxValue = 10000

        binding.secondNumber.setOnValueChangedListener{_, _, _ -> mdc()}
        binding.firstNumber.setOnValueChangedListener{_, _, _ -> mdc()}
    }

    private fun mdc(){
        var d = binding.firstNumber.value
        var div = binding.secondNumber.value

        while (d % div != 0) {
            val r = d % div
            d = div
            div = r
        }

        binding.resultmdc.text = String.format("O mdc de ${binding.firstNumber.value} e ${binding.secondNumber.value} é: %d", div)
    }
}