package com.example.app_imc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Imc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)

        val editTextPeso = findViewById<EditText>(R.id.edit_text_peso)
        val editTextAltura = findViewById<EditText>(R.id.edit_text_altura)
        val buttonCalcular = findViewById<Button>(R.id.btnSalvar)
        val textViewResultado = findViewById<TextView>(R.id.textView)

        buttonCalcular.setOnClickListener {
            val pesoText = editTextPeso.text.toString()
            val alturaText = editTextAltura.text.toString()

            if (pesoText.isEmpty() || alturaText.isEmpty()) {
                textViewResultado.text = "Preencha todos os campos!"
                textViewResultado.setTextColor(getColor(android.R.color.holo_red_dark))
                return@setOnClickListener
            }

            val peso = pesoText.toFloat()
            val altura = alturaText.toInt()

            if (altura <= 0 || peso <= 0) {
                textViewResultado.text = "Valores inválidos!"
                textViewResultado.setTextColor(getColor(android.R.color.holo_red_dark))
                return@setOnClickListener
            }

            val alturaM = altura.toFloat() / 100

            // Cálculo do IMC
            val imc = peso / (alturaM * alturaM)

            // Classificação do IMC
            val resultado = when {
                imc < 18.5 -> "Abaixo do peso"
                imc in 18.5..24.9 -> "Peso normal"
                imc in 25.0..29.9 -> "Sobrepeso"
                imc in 30.0..34.9 -> "Obesidade Grau 1"
                imc in 35.0..39.9 -> "Obesidade Grau 2"
                else -> "Obesidade Grau 3"
            }

            textViewResultado.text = "Resultado: $resultado"
            textViewResultado.setTextColor(getColor(android.R.color.white))

        }
    }
}