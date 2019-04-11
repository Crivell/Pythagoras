package com.crivell.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SimpleActivity : AppCompatActivity() {

    val calculator : Calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
    }
}
