package com.example.bmi_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val btnShow = findViewById<Button>(R.id.btnShow)

        btnShow.setOnClickListener {

            val name = etName.text.toString()
            val age = etAge.text.toString()
            val height = etHeight.text.toString()
            val weight = etWeight.text.toString()

            if (name.isEmpty() || age.isEmpty() || height.isEmpty() || weight.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
        }
    }
}