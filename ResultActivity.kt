package com.example.bmi_calculator

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bmi_calculator.R
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvDetails = findViewById<TextView>(R.id.tvDetails)
        val tvBMI = findViewById<TextView>(R.id.tvBMI)
        val layout = findViewById<LinearLayout>(R.id.resultLayout)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val bmiCard = findViewById<LinearLayout>(R.id.bmiCard)

        val name = intent.getStringExtra("name")!!
        val age = intent.getStringExtra("age")!!
        val heightCm = intent.getStringExtra("height")!!.toDouble()
        val weight = intent.getStringExtra("weight")!!.toDouble()

        val heightM = heightCm / 100
        val bmi = weight / heightM.pow(2)

        val category: String
        val color: Int

        when {
            bmi < 18.5 -> {
                category = "Underweight"
                color = Color.parseColor("#BBDEFB") // light blue
            }
            bmi <= 24.9 -> {
                category = "Normal"
                color = Color.parseColor("#C8E6C9") // light green
            }
            else -> {
                category = "Overweight"
                color = Color.parseColor("#FFCDD2") // light red
            }
        }

        btnBack.setOnClickListener {
            finish() // goes back to MainActivity
        }

        tvDetails.text = "Name: $name\nAge: $age"
        tvBMI.text = "BMI: %.2f\nCategory: $category".format(bmi)
        layout.setBackgroundColor(color)
    }
}