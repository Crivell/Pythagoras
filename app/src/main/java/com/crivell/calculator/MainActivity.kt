@file:Suppress("UsePropertyAccessSyntax")

package com.crivell.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val calculator : Calculator = Calculator()
    lateinit var one : Button
    lateinit var two : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one = advance
        one.setOnClickListener {
            clickOneButton()
        }
        two = about
        two.setOnClickListener {
            clickTwoButton()
        }
    }

    fun clickOneButton(){
        calculator.a = (calculator.a * 10) + 1
        text.setText(calculator.a.toLong().toString())
    }

    fun clickTwoButton(){
        calculator.a = (calculator.a * 10) + 2
        text.setText(calculator.a.toLong().toString())
    }

}
