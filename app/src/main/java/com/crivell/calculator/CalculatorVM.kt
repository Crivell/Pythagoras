package com.crivell.calculator

import RPN.ReversePolishNotation
import android.arch.lifecycle.ViewModel
import java.lang.Exception

class CalculatorVM : ViewModel() {

    private var isLastDigit: Boolean
    var display : String
    var result : String
    var first : Boolean
    var isDot : Boolean
    var isAction : Boolean
    var isLastDot : Boolean
    var isDigit : Boolean

    init {
        display = ""
        result = ""
        first = false
        isDot = false
        isAction = true
        isLastDot = false
        isDigit = false
        isLastDigit = false
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
        addSimbol(" ^ 2")
    }

    fun per(){
        addSimbol(" % ")
    }

    fun clear(){
        display = " "
        result = " "
        first = false
        isDot = false
        isAction = true
        isLastDot = false
        isDigit = false
        isLastDigit = false
    }

    fun addingNumber(x:Double){
        if(!isDigit) {
            display += x.toInt().toString()
            isAction = false
            isLastDot = false
            isLastDigit = true
            if (!first) {
                first = true
            }
        }

    }

    fun equal():String{
        try{
            if(display.length > 0){
                if(first){
                    result = ReversePolishNotation.solveEq(this.display.replace('.',','))
                }
            }
        }catch (e : Exception){
            result = "Niedozwolone dzialanie"
        }
        this.result.replace(',','.')
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
            if(display.last().equals('.')){
                isDot = false
            }

            var s : String = display.takeLast(5)
            if(s.equals(" log ") || s.equals(" sin ") || s.equals(" cos ") || s.equals(" tan ")){
                display = display.dropLast(4 )
            }
            s = display.takeLast(3)
            if(s.equals(" + ") || s.equals(" - ") || s.equals(" / ") || s.equals(" * ")|| s.equals(" % ") || s.equals(" ^ ") || s.equals(" ( ") || s.equals(" ) ")){
                display = display.dropLast(2 )
            }
            s = display.takeLast(4)
            if( s.equals(" ln ") || s.equals(" ^ 2")){
                display = display.dropLast(3 )
            }

            display = display.dropLast(1 )
        }else{
            display = " "
            first = false
            isDot = false
            isAction = true
            isLastDot = false
            isDigit = false
            isLastDigit = false
        }
    }

    fun addSimbol(s:String){
        if(s.equals(" % ")){
            if(!isAction ){
                if(!isDigit){
                    display += s
                    isDigit = true
                }
            }
        }else{
            if(s.equals(" ( ")){
                if(!isAction){
                    if(isDigit){
                        display += s
                        isDigit = false
                    }
                }
            }
            if(!isLastDot){
                if(s.equals(" ln ") || s.equals(" log ") || s.equals(" sin ") || s.equals(" cos ") || s.equals(" tan ")){
                    if(!isLastDigit){
                        display += s
                        isLastDigit = false
                    }
                }else{
                    if(!isAction){
                        display += s
                        isAction = true
                        first = false
                        isDot = false
                        isDigit = false
                        isLastDigit = false
                    }
                }

            }
        }

    }

    fun getResoutl() :String{
        return result.replace(',','.')
    }
}