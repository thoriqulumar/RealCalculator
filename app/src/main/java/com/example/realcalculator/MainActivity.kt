package com.example.realcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var operation:String?=null
    var condition:Boolean = true
    lateinit var oldNumber:String
    lateinit var newNumber:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonMain(view:View){

        if(condition){
            editText.setText("")
        }

        condition = false

        var button = view as Button
        var buttonValue:String =editText.text.toString()


        when(button.id){
            btn0.id ->{
                buttonValue += "0"
            }
            btn1.id ->{
                buttonValue += "1"
            }
            btn2.id ->{
                buttonValue += "2"
            }
            btn3.id ->{
                buttonValue += "3"
            }
            btn4.id ->{
                buttonValue += "4"
            }
            btn5.id ->{
                buttonValue += "5"
            }
            btn6.id ->{
                buttonValue += "6"
            }
            btn7.id ->{
                buttonValue += "7"
            }
            btn8.id ->{
                buttonValue += "8"
            }
            btn9.id ->{
                buttonValue += "9"
            }
            btnTitik.id ->{
                buttonValue += "."
            }
            btnNegative.id ->{
                buttonValue = "-"+buttonValue
            }
        }

        editText.setText(buttonValue)


    }



    fun buttonOperation(view:View){

        var buttonOper = view as Button
        when(buttonOper.id){
            btnDiv.id ->{
                operation = "/"
            }
            btnPlus.id ->{
                operation = "+"
            }
            btnMin.id ->{
                operation = "-"
            }
            btnKali.id ->{
                operation = "*"
            }
        }
        oldNumber = editText.text.toString()
        condition = true
    }

    fun buttonSum(view:View){
        newNumber = editText.text.toString()
        var result:Double?=null
        when(operation){
            "/" -> {
                result = oldNumber.toDouble() /newNumber.toDouble()
            }

            "-" -> {
                result = oldNumber.toDouble() -newNumber.toDouble()
            }

            "+" -> {
                result = oldNumber.toDouble() +newNumber.toDouble()
            }

            "*" -> {
                result = oldNumber.toDouble() *newNumber.toDouble()
            }
        }

        editText.setText(result.toString())
        condition = true
    }

    fun buttonPercent(view:View){
        var percent = editText.text.toString().toDouble() / 100

        editText.setText(percent.toString())
    }

    fun buttonClean(view:View){
        editText.setText("0")
        condition = true
    }
}
