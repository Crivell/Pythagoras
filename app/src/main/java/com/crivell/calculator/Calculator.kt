package com.crivell.calculator

enum class CalculatorOperation{
    SUM, SUB, MUL, DIV
}

class Calculator {


    var a:Double = 0.0
    var b:Double = 0.0
    var lastUseOperation : CalculatorOperation = CalculatorOperation.SUM

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