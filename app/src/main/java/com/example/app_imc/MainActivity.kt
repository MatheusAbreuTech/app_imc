package com.example.app_imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonAvancar= findViewById<Button>(R.id.btnAvancar)
        buttonAvancar.setOnClickListener {
            val intent = Intent(this, Imc::class.java)
            startActivity(intent)
        }
    }
}