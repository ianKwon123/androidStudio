package com.example.checking

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.roundToInt

class ResultActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)

        Log.d("ResultActivity","height : $height , weight : $weight")
        val bmi = (weight / (height / 100.0).pow(2.0)*10).roundToInt() /10f
        val resultText = when {
            bmi >= 30.0 -> "obesity"
            bmi >= 25.0 -> "overweight"
            bmi >= 18.5 -> "normal weight"
            else -> "underweight"
        }

        val resultValueTextView = findViewById<TextView>(R.id.bmiResultTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
    }
}