package com.crivell.calculator

import RPN.ReversePolishNotation
import android.arch.lifecycle.ViewModel

class CalculatorVM : ViewModel() {

    var display : String
    var result : String
    var first : Boolean
    var isDot : Boolean
    var isAction : Boolean
    var isLastDot : Boolean
    init {
        display = ""
        result = ""
        first = false
        isDot = false
        isAction = true
        isLastDot = false
    }

    fun sum(){
        addSimbol(" * ")
    }

    fun sub(){
        addSimbol(" - ")
    }

    fun div(){
        addSimbol(" / ")
    }

    fun mul(){
        addSimbol(" * ")
    }

    fun clear(){
        display = ""
        result = ""
        first = false
        isDot = false
        isAction = true
        isLastDot = false
    }

    fun addingNumber(x:Double){
            display += x.toInt().toString()
            isAction = false
            isLastDot = false
            if(!first){
                first = true
            }


    }

    fun equal():String{
        if(first){
            result = ReversePolishNotation.solveEq(this.display)
        }
        return result
    }

    fun addDot(){
        if(first){
            if(!isDot){
                isDot=true
                display+="."
                isLastDot = true
            }
        }
    }

    fun bksp(){
        if(display.length >=1){
            display = display.dropLast(1)
        }
    }

    fun addSimbol(s:String){
        if(!isLastDot){
            if(!isAction){
                display += s
                isAction = true
                first = false
                isDot = false
            }
        }
    }
}