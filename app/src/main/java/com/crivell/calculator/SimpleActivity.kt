package com.crivell.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_simple.*
import java.time.format.TextStyle

class SimpleActivity : AppCompatActivity() {

    val calculator : Calculator = Calculator()
    lateinit var bkspButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        bkspButton = bksp
        bkspButton.setOnClickListener {
            bkspButtonClick()
        }
    }

    fun bkspButtonClick(){
        calculator.display = "sdasdasd"
        text.setText(calculator.display)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putCharSequence("savedText", calculator.display)
        outState?.putCharSequence("lastUse",calculator.lastUseOperation.toString())
        outState?.putCharSequence("b",calculator.b.toString())
        outState?.putCharSequence("isFirst",calculator.isFirst.toString())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        calculator.display = savedInstanceState?.getCharSequence("savedText").toString()
        text.setText(calculator.display)
        calculator.lastUseOperation = CalculatorOperation.valueOf(savedInstanceState?.getCharSequence("lastUse").toString())
        calculator.b = savedInstanceState?.getCharSequence("b").toString().toDouble()
        calculator.isFirst = savedInstanceState?.getCharSequence("isFirst").toString().toBoolean()
    }
}
