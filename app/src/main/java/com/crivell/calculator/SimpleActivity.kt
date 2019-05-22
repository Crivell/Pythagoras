package com.crivell.calculator

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_simple.*

class SimpleActivity : AppCompatActivity() {

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
    lateinit var leftButton:Button
    lateinit var rightButton:Button
    lateinit var sinButton:Button
    lateinit var cosButton:Button
    lateinit var tanButton:Button
    lateinit var logButton:Button
    lateinit var lnButton:Button
    lateinit var powNButton:Button
    lateinit var pow2Button:Button
    lateinit var perButton:Button



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

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

            /*
            lateinit var leftButton:Button
            lateinit var rightButton:Button
            lateinit var sinButton:Button
            lateinit var cosButton:Button
            lateinit var tanButton:Button
            lateinit var logButton:Button
            lateinit var lnButton:Button
            lateinit var powNButton:Button
            lateinit var pow2Button:Button
            lateinit var perButton:Button
             */

            leftButton = left
            leftButton.setOnClickListener {
                calculatorVM.left()
                text.setText(calculatorVM.display)
            }
            rightButton = right
            rightButton.setOnClickListener {
                calculatorVM.right()
                text.setText(calculatorVM.display)
            }
            sinButton = sin
            sinButton.setOnClickListener {
                calculatorVM.sin()
                text.setText(calculatorVM.display)
            }
            cosButton = cos
            cosButton.setOnClickListener {
                calculatorVM.cos()
                text.setText(calculatorVM.display)
            }
            tanButton = tan
            tanButton.setOnClickListener {
                calculatorVM.tan()
                text.setText(calculatorVM.display)
            }
            logButton = log
            logButton.setOnClickListener {
                calculatorVM.log()
                text.setText(calculatorVM.display)
            }
            lnButton = ln
            lnButton.setOnClickListener {
                calculatorVM.ln()
                text.setText(calculatorVM.display)
            }
            powNButton = pown
            powNButton.setOnClickListener {
                calculatorVM.powN()
                text.setText(calculatorVM.display)
            }
            pow2Button = pow2
            pow2Button.setOnClickListener {
                calculatorVM.pow2()
                text.setText(calculatorVM.display)
            }
            perButton = percent
            powNButton.setOnClickListener {
                calculatorVM.per()
                text.setText(calculatorVM.display)
            }



        }

    }

    fun plusMinusButtonClick(){
        calculatorVM.plusMinus()
        text.setText(calculatorVM.result)
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
        outState?.putCharSequence("savedText", calculatorVM.display)
        outState?.putCharSequence("result", calculatorVM.result)
        outState?.putCharSequence("first", calculatorVM.first.toString())
        outState?.putCharSequence("isDot", calculatorVM.isDot.toString())
        outState?.putCharSequence("isAction", calculatorVM.isAction.toString())
        outState?.putCharSequence("isLastDot", calculatorVM.isLastDot.toString())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        calculatorVM.display = savedInstanceState?.getCharSequence("savedText").toString()
        text.setText(calculatorVM.display)
        calculatorVM.result= savedInstanceState?.getCharSequence("result").toString()
        resoult.setText(calculatorVM.result)
        calculatorVM.first= savedInstanceState?.getCharSequence("first").toString().toBoolean()
        calculatorVM.isDot= savedInstanceState?.getCharSequence("isDot").toString().toBoolean()
        calculatorVM.isAction= savedInstanceState?.getCharSequence("isAction").toString().toBoolean()
        calculatorVM.isLastDot= savedInstanceState?.getCharSequence("isLastDot").toString().toBoolean()
    }
}
