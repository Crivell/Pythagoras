package com.crivell.calculator

import RPN.ReversePolishNotation
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_simple.*
import java.time.format.TextStyle

class SimpleActivity : AppCompatActivity() {

    val calculator : Calculator = Calculator()
    lateinit var bkspButton: Button
    lateinit var clearButton:Button
    lateinit var plusMinusButton:Button
    lateinit var divideButton : Button
    lateinit var dotButton:Button
    lateinit var equalButton:Button
    lateinit var mulButton:Button
    lateinit var sumButton: Button
    lateinit var subButton: Button

    lateinit var nineButton:Button
    lateinit var eightButton:Button
    lateinit var sevenButton:Button
    lateinit var sixButton:Button
    lateinit var fiveButton:Button
    lateinit var fournButton:Button
    lateinit var threeButton:Button
    lateinit var twoButton:Button
    lateinit var oneButton:Button
    lateinit var zeroButton:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
//        bkspButton = bksp
//        bkspButton.setOnClickListener {
//            bkspButtonClick()
//        }
//
//        clearButton = clear
//        clearButton.setOnClickListener {
//            clearButtonClick()
//        }
//
//        plusMinusButton = plusMinus
//        plusMinusButton.setOnClickListener {
//            plusMinusButtonClick()
//        }
//
//        divideButton = divide
//        divideButton.setOnClickListener {
//            calculator.div()
//            text.setText(calculator.display)
//        }
//
//        mulButton = mul
//        mulButton.setOnClickListener {
//            calculator.mul()
//            text.setText(calculator.display)
//        }
//
//        subButton = sub
//        subButton.setOnClickListener {
//            calculator.sub()
//            text.setText(calculator.display)
//        }
//
//        sumButton = sum
//        sumButton.setOnClickListener {
//            calculator.sum()
//            text.setText(calculator.display)
//        }
        nineButton = nine
        nineButton.setOnClickListener {
            calculator.updateValue(9.0)
            text.setText(calculator.display)
        }

//        dotButton = dot
//        dotButton.setOnClickListener {
//            calculator.addDot()
//            text.setText(calculator.display)
//        }
//
//        equalButton = equal
//        equalButton.setOnClickListener {
//            calculator.equal()
//            text.setText(calculator.display)
//        }

        eightButton = eight
        eightButton.setOnClickListener {
            calculator.updateValue(8.0)
            text.setText(calculator.display)
        }

        sevenButton = seven
        sevenButton.setOnClickListener {
            calculator.updateValue(7.0)
            text.setText(calculator.display)
        }
        sixButton = six
        sixButton.setOnClickListener {
            calculator.updateValue(6.0)
            text.setText(calculator.display)
        }
        fiveButton = five
        fiveButton.setOnClickListener {
            calculator.updateValue(5.0)
            text.setText(calculator.display)
        }

        fournButton = four
        fournButton.setOnClickListener {
            calculator.updateValue(4.0)
            text.setText(calculator.display)
        }

        threeButton = three
        threeButton.setOnClickListener {
            calculator.updateValue(3.0)
            text.setText(calculator.display)
        }

        twoButton = two
        twoButton.setOnClickListener {
            calculator.updateValue(2.0)
            text.setText(calculator.display)
        }

        oneButton = one
        oneButton.setOnClickListener {
            calculator.updateValue(1.0)
            text.setText(calculator.display)
        }

        zeroButton = zero
        zeroButton.setOnClickListener {
            calculator.updateValue(0.0)
            text.setText(calculator.display)
        }
        text.setText(ReversePolishNotation.solveEq("10 + 2 * 10 / 2 + ( 2 + 1 ) "))
    }

    fun plusMinusButtonClick(){
        calculator.plusMinut()
        text.setText(calculator.display)
    }

    fun bkspButtonClick(){
        calculator.bksp()
        text.setText(calculator.display)
    }

    fun clearButtonClick(){
        calculator.display = ""
        text.setText(calculator.display)
        calculator.clear()
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
