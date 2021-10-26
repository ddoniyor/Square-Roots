package com.example.quadraticroots

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGetResult.setOnClickListener {
            if (editTextA.text.isNotEmpty() && editTextB.text.isNotEmpty() && editTextC.text.isNotEmpty()) {
                resultText.text = findRoots(
                    editTextA.text.toString().toDouble(),
                    editTextB.text.toString().toDouble(),
                    editTextC.text.toString().toDouble()
                )
            } else {
                Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun findRoots(a: Double=1.0, b: Double=1.0, c: Double): String {
        var d = b * b - 4 * a * c
        var result = when {
            d > 0.0 -> {
                var x1 = (-b - sqrt(d) / (2 * a))
                var x2 = (-b + sqrt(d) / (2 * a))
                "Корни квадратного уровнения x1 = ${roundNumber(x1)}, x2 = ${roundNumber(x2)}"
            }
            d == 0.0 -> {
                var x = -b / (2 * a)
                "Корень один x = ${roundNumber(x)}"
            }
            else -> {
                "В уровнении нет корней"
            }
        }
        return result
    }
    private fun roundNumber(number: Double): Float {
        return number.toBigDecimal().setScale(2, RoundingMode.UP).toFloat()
    }
}