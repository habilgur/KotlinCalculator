package com.example.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var operationMark: String? = null
    var firstNum: Double? = null
    var secondNum = 0.0
    var temproraryText =""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt0.setOnClickListener { view -> digitClick(view) }
        bt1.setOnClickListener { view -> digitClick(view) }
        bt2.setOnClickListener { view -> digitClick(view) }
        bt3.setOnClickListener { view -> digitClick(view) }
        bt4.setOnClickListener { view -> digitClick(view) }
        bt5.setOnClickListener { view -> digitClick(view) }
        bt6.setOnClickListener { view -> digitClick(view) }
        bt7.setOnClickListener { view -> digitClick(view) }
        bt8.setOnClickListener { view -> digitClick(view) }
        bt9.setOnClickListener { view -> digitClick(view) }
        btDecimal.setOnClickListener { view -> digitClick(view) }
        btCLR.setOnClickListener { clear() }

        btPlus.setOnClickListener { view -> operatorClick(view) }
        btDiv.setOnClickListener { view -> operatorClick(view) }
        btMultiply.setOnClickListener { view -> operatorClick(view) }
        btMMinus.setOnClickListener { view -> operatorClick(view) }
        btEqual.setOnClickListener { view -> equalClick(view) }


    }

    private fun digitClick(view: View) {
        var button = view as Button
        tvInput.append(button.text.toString())

        var displayedNumText: String


        if (operationMark == null)
            displayedNumText = tvInput.text.toString()
        else {
            temproraryText += button.text.toString()
            displayedNumText = temproraryText
        }


        saveNumbers(displayedNumText)
    }

    private fun operatorClick(view: View) {
        var button = view as Button
        var selectedButtonText = button.text.toString()

        tvInput.append(selectedButtonText)

        operationMark = button.text.toString()
    }

    private fun equalClick(view: View) {

        var result = when (operationMark) {
            "+" -> firstNum!! + secondNum
            "-" -> firstNum!! - secondNum
            "/" -> firstNum!! / secondNum
            "X" -> firstNum!! * secondNum

            else -> 0.0
        }

        tvInput.text = result.toString()
        firstNum = result
        temproraryText = ""
    }

    private fun saveNumbers(displayedNumText: String) {
        if(displayedNumText==".") return
        if (firstNum == null || operationMark == null)
            firstNum = displayedNumText.toDouble()
        else
            secondNum = displayedNumText.toDouble()
    }

    private fun  clear(){
        operationMark=null
        firstNum=null
        secondNum=0.0
        temproraryText=""
        tvInput.text=""

    }


}
