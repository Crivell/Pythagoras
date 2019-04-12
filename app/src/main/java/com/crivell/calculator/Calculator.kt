package com.crivell.calculator

import android.arch.lifecycle.ViewModel

enum class CalculatorOperation(val value:String) {
    SUM("sum"),
    SUB("sub"),
    MUL("mul"),
    DIV("div")
}

class Calculator() : ViewModel() {



    var display : String
    var a : Double
    var b : Double
    var lastUseOperation : CalculatorOperation
    var isFirst : Boolean
    var isDot:Boolean
    var isAfterEqual:Boolean


    init {
        this.display = ""
        this.a = 0.0
        this.b = 0.0
        this.lastUseOperation = CalculatorOperation.SUM
        this.isFirst = true
        this.isDot = false
        this.isAfterEqual = false
    }


    fun sum():Double{
        lastUseOperation = CalculatorOperation.SUM
        a+=b
        display = a.toString()
        return a
    }

    fun sub():Double{
        lastUseOperation = CalculatorOperation.SUB
        a-=b
        display = a.toString()
        return a
    }

    fun mul():Double{
        lastUseOperation = CalculatorOperation.MUL
        a*=b
        display = a.toString()
        return a
    }

    fun div():Double{
        lastUseOperation = CalculatorOperation.DIV
        if(!isFirst){
            a/=b
        }
        isFirst = false
        display = ""
        return a
    }

    fun equal(){


        when(lastUseOperation){
            CalculatorOperation.SUM -> sum()
            CalculatorOperation.SUB -> sub()
            CalculatorOperation.MUL -> mul()
            CalculatorOperation.DIV -> div()
        }
        display = a.toString()
        isAfterEqual = true
    }

    fun clear(){
        this.a = 0.0
        this.b = 0.0
        this.isFirst = true
        lastUseOperation = CalculatorOperation.SUM
    }

    fun plusMinut(){
        if(!a.equals(0.0)){
            a*=(-1)
            this.display = a.toString()
        }
    }

    fun updateValue(x:Double){

        if (isAfterEqual){
            isFirst=true
            isAfterEqual = false
            this.display = ""
        }
        this.display += x.toInt().toString()
        if(isFirst){
            a = this.display.toDouble()
        }else{
            b=this.display.toDouble()
        }
    }

    fun addDot(){
        if(!isDot){
            display+="."
        }
    }
}