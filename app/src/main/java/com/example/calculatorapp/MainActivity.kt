package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isNewOp = true
    var oldNumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun numberEvent(view: View) {
        if (isNewOp) {
            eT.setText("")
        }
        isNewOp = false
        var buClick:String = eT.text.toString()
        var buSelect:Button = view as Button
        when(buSelect.id) {
            bu1.id -> {buClick += "1"}
            bu2.id -> {buClick += "2"}
            bu3.id -> {buClick += "3"}
            bu4.id -> {buClick += "4"}
            bu5.id -> {buClick += "5"}
            bu6.id -> {buClick += "6"}
            bu7.id -> {buClick += "7"}
            bu8.id -> {buClick += "8"}
            bu9.id -> {buClick += "9"}
            bu0.id -> {buClick += "0"}
            buDot.id -> {buClick += "."}
            buPlusMinus.id -> {buClick = "-$buClick"}
        }
        eT.setText(buClick)
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = eT.text.toString()
        var buSelect:Button = view as Button
        when(buSelect.id) {
            buMultiply.id -> {op = "*"}
            buPlus.id -> {op = "+"}
            buMinus.id -> {op = "-"}
            buDivide.id -> {op = "/"}
            buPercent.id -> {op = "%"}
        }
    }

    fun equalEvent(view: View) {
        var newNumber = eT.text.toString()
        var result = 0.0
        when(op) {
            "+" -> {result = oldNumber.toDouble() + newNumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newNumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newNumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newNumber.toDouble()}
            "%" -> {result = oldNumber.toDouble() % newNumber.toDouble()}
        }
        eT.setText(result.toString())
    }

    fun acEvent(view: View) {
        eT.setText("0")
        isNewOp = true
    }

    fun percentEvent(view: View) {
        var no = eT.text.toString().toDouble()/100
        eT.setText(no.toString())
        isNewOp = true
    }
}