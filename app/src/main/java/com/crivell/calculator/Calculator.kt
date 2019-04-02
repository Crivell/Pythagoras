package com.crivell.calculator

import android.arch.lifecycle.ViewModel

enum class CalculatorOperation {
    SUM, SUB, MUL, DIV
}

class Calculator() : ViewModel() {




    var a : Double
    var b : Double
    var lastUseOperation : CalculatorOperation
    var isFirst : Boolean

    init {
        this.a = 0.0
        this.b = 0.0
        this.lastUseOperation = CalculatorOperation.SUM
        this.isFirst = true
    }


    fun sum(a:Double,b:Double):Double{
        lastUseOperation = CalculatorOperation.SUM
        return a+b
    }

    fun sub(a:Double,b:Double):Double{
        lastUseOperation = CalculatorOperation.SUB
        return a-b
    }

    fun mul(a:Double,b:Double):Double{
        lastUseOperation = CalculatorOperation.MUL
        return a*b
    }

    fun div(a:Double,b:Double):Double{
        lastUseOperation = CalculatorOperation.DIV
        return a/b
    }



}