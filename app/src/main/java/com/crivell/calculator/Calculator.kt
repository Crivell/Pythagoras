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
    var result : String
    var a : Double
    var b : Double
    var lastUseOperation : CalculatorOperation
    var isFirst : Boolean
    var isDot:Boolean
    var isAfterEqual:Boolean
    var isAfter :Boolean
    var isFirstMinus:Boolean

    init {
        this.display = ""
        this.result = ""
        this.a = 0.0
        this.b = 0.0
        this.lastUseOperation = CalculatorOperation.SUM
        this.isFirst = true
        this.isDot = false
        this.isAfterEqual = false
        this.isAfter = false
        this.isFirstMinus = false
    }


    fun sum():Double{
        lastUseOperation = CalculatorOperation.SUM
        if(!isFirst){
            a+=b
        }
        if(!hasDecimalPiont(a)){
            display = a.toString()
        }else{
            display = a.toInt().toString()
        }
        addingSecoundDigitInit()
        return a
    }

    fun sub():Double{
        lastUseOperation = CalculatorOperation.SUB

        if(!isFirst){
            a-=b
        }else{
            isFirstMinus = true
        }
        if(!hasDecimalPiont(a)){
            display = a.toString()
        }else{
            display = a.toInt().toString()
        }
        addingSecoundDigitInit()
        return a
    }

    fun mul():Double{
        lastUseOperation = CalculatorOperation.MUL
        if(!isFirst){
            a*=b
        }

        if(!hasDecimalPiont(a)){
            display = a.toString()
        }else{
            display = a.toInt().toString()
        }
        addingSecoundDigitInit()

        return a
    }

    fun div():Double{
        lastUseOperation = CalculatorOperation.DIV
        if(!isFirst){
            a/=b
        }

        if(!hasDecimalPiont(a)){
            display = a.toString()
        }else{
            display = a.toInt().toString()
        }
        addingSecoundDigitInit()

        return a
    }

    fun equal(){


        when(lastUseOperation){
            CalculatorOperation.SUM -> sum()
            CalculatorOperation.SUB -> sub()
            CalculatorOperation.MUL -> mul()
            CalculatorOperation.DIV -> div()
        }
        if(!hasDecimalPiont(a)){
            display = a.toString()
        }else{
            display = a.toInt().toString()
        }
        isAfterEqual = true
    }

    fun clear(){
        this.a = 0.0
        this.b = 0.0
        this.isFirst = true
        isDot = false
        lastUseOperation = CalculatorOperation.SUM
    }

    fun plusMinut(){
        if(!a.equals(0.0)){
            a*=(-1)

            if(!hasDecimalPiont(a)){
                display = a.toString()
            }else{
                display = a.toInt().toString()
            }
        }
    }

    fun updateValue(x:Double){

        if (isAfterEqual){
            isFirst=true
            isAfterEqual = false
            this.display = ""
        }

        if(isAfter ){
            display = ""
            isAfter = false
        }


        this.display += x.toInt().toString()


        if(isFirst){
            a = this.display.toDouble()
        }else{
            b = this.display.toDouble()
        }

    }

    fun addDot(){
        if(!isDot){
            isDot=true
            display+="."
        }
    }

    fun addingSecoundDigitInit(){
        isFirst = false
        this.isAfter = true
        if(!hasDecimalPiont(a)){
            display = a.toString()
        }else{
            display = a.toInt().toString()
        }
        isDot = false
    }

    fun hasDecimalPiont(x:Double):Boolean{
        if(x - x.toInt().toDouble() == 0.0){
            return true
        }else{
            return false
        }
    }
    fun bksp(){
        if(display.length >=1){
            a = display.toDouble()
        }
        display = display.dropLast(1)
    }
}