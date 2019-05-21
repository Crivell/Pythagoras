package com.crivell.calculator

import RPN.ReversePolishNotation
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_simple.*

class SimpleActivity : AppCompatActivity() {

    val calculator : Calculator = Calculator()
    val calculatorVM:CalculatorVM = CalculatorVM()
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
        bkspButton = bksp
        bkspButton.setOnClickListener {
            bkspButtonClick()
        }

        clearButton = clear
        clearButton.setOnClickListener {
            clearButtonClick()
        }

        plusMinusButton = plusMinus
        plusMinusButton.setOnClickListener {
            plusMinusButtonClick()
        }

        divideButton = divide
        divideButton.setOnClickListener {
            calculatorVM.div()
            text.setText(calculatorVM.display)
        }

        mulButton = mul
        mulButton.setOnClickListener {
            calculatorVM.mul()
            text.setText(calculatorVM.display)
        }

        subButton = sub
        subButton.setOnClickListener {
            calculatorVM.sub()
            text.setText(calculatorVM.display)
        }

        sumButton = sum
        sumButton.setOnClickListener {
            calculatorVM.sum()
            text.setText(calculatorVM.display)
        }
        nineButton = nine
        nineButton.setOnClickListener {
            calculatorVM.addingNumber(9.0)
            text.setText(calculatorVM.display)
        }

        dotButton = dot
        dotButton.setOnClickListener {
            calculatorVM.addDot()
            text.setText(calculatorVM.display)
        }

        equalButton = equal
        equalButton.setOnClickListener {
            calculatorVM.equal()
            resoult.setText(calculatorVM.result)
        }

        eightButton = eight
        eightButton.setOnClickListener {
            calculatorVM.addingNumber(8.0)
            text.setText(calculatorVM.display)
        }

        sevenButton = seven
        sevenButton.setOnClickListener {
            calculatorVM.addingNumber(7.0)
            text.setText(calculatorVM.display)
        }
        sixButton = six
        sixButton.setOnClickListener {
            calculatorVM.addingNumber(6.0)
            text.setText(calculatorVM.display)
        }
        fiveButton = five
        fiveButton.setOnClickListener {
            calculatorVM.addingNumber(5.0)
            text.setText(calculatorVM.display)
        }

        fournButton = four
        fournButton.setOnClickListener {
            calculatorVM.addingNumber(4.0)
            text.setText(calculatorVM.display)
        }

        threeButton = three
        threeButton.setOnClickListener {
            calculatorVM.addingNumber(3.0)
            text.setText(calculatorVM.display)
        }

        twoButton = two
        twoButton.setOnClickListener {
            calculatorVM.addingNumber(2.0)
            text.setText(calculatorVM.display)
        }

        oneButton = one
        oneButton.setOnClickListener {
            calculatorVM.addingNumber(1.0)
            text.setText(calculatorVM.display)
        }

        zeroButton = zero
        zeroButton.setOnClickListener {
            calculatorVM.addingNumber(0.0)
            text.setText(calculatorVM.display)
        }

    }

    fun plusMinusButtonClick(){
        calculator.plusMinut()
        text.setText(calculator.display)
    }

    fun bkspButtonClick(){
        calculatorVM.bksp()
        text.setText(calculatorVM.display)
    }

    fun clearButtonClick(){

        calculatorVM.clear()
        text.setText(calculatorVM.display)
        resoult.setText(calculatorVM.result)
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
