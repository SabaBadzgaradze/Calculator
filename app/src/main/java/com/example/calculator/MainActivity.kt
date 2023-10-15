package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operationPerformed: Boolean = false

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

    }

    fun numberClick(clickView: View) {
        if (clickView is TextView) {
            val result = resultTextView.text.toString()
            val number = clickView.text.toString()

            if (result == "0"){
                resultTextView.text = ""
            }

            if (operationPerformed) {
                resultTextView.text = number
                operationPerformed = false
            } else {
                resultTextView.text = resultTextView.text.toString() + number
            }
        }
    }

    fun operationClick(clickView: View){

        if (clickView is TextView){
            val result = resultTextView.text.toString()

            if (result.isNotEmpty()){
                operand = result.toDouble()
            }

            operation = clickView.text.toString()

            resultTextView.text = ""
        }

        when(operation){
            "+/-" -> resultTextView.text = (operand * (-1)).toString()
        }
    }

    fun equalsClick(clickView: View) {
        val secOperandText = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if (secOperandText.isNotEmpty()) {
            secOperand = secOperandText.toDouble()
        }

        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "×" -> resultTextView.text = (operand * secOperand).toString()
            "÷" -> resultTextView.text = (operand / secOperand).toString()
            "%" -> resultTextView.text = ((operand * secOperand)/100).toString()
        }

        operationPerformed = true
    }

    fun clearClick(clickedView: View){

        val result = resultTextView.text.toString()

        if (result.isNotEmpty()){
            resultTextView.text = ""
            operand = 0.0
        }
    }

    fun dotClick(clickedView: View){

        if (clickedView is TextView){

            val result = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (result.isNotEmpty()){

                if (result.contains(".")){
                    return
                }
                resultTextView.text = result + number
            }

        }

    }
}