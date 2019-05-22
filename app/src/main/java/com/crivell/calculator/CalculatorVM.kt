package com.crivell.calculator

import RPN.ReversePolishNotation
import android.arch.lifecycle.ViewModel
import java.lang.Exception

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

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
    }

    fun plusMinus(){
       // display += " ( -1 ) "
    }

    fun sum(){
        addSimbol(" + ")
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

    fun left(){
        addSimbol(" ( ")
    }

    fun right(){
        addSimbol(" ) ")
    }

    fun sin(){
        addSimbol(" sin ")
    }

    fun cos(){
        addSimbol(" cos ")
    }

    fun tan(){
        addSimbol(" tan ")
    }

    fun log(){
        addSimbol(" log ")
    }

    fun ln(){
        addSimbol(" ln ")
    }

    fun powN(){
        addSimbol(" ^ ")
    }

    fun pow2(){
        addSimbol(" ^ 2 ")
    }

    fun per(){
        addSimbol(" % ")
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
        try{
            if(display.length > 0){
                if(first){
                    result = ReversePolishNotation.solveEq(this.display)
                }
            }
        }catch (e : Exception){
            result = "Niedozwolone dzialanie"
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