@file:Suppress("UsePropertyAccessSyntax")

package com.crivell.calculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var simpleButton : Button
    lateinit var advanceButton : Button
    lateinit var aboutButton : Button
    lateinit var exitButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simpleButton = simple
        simpleButton.setOnClickListener {
            clickSimpleButton()
        }

        advanceButton = advance
        advanceButton.setOnClickListener {
            clickAdvanceButton()
        }

        aboutButton = about
        aboutButton.setOnClickListener {
            clickAboutButton()
        }

        exitButton = exit
        exitButton.setOnClickListener {
            clickExitButton()
        }
    }

    fun clickSimpleButton(){
        val intent = Intent(this,SimpleActivity::class.java)
        startActivity(intent)
    }

    fun clickAdvanceButton(){
        val intent = Intent(this,AdvanceActivity::class.java)
        startActivity(intent)
    }

    fun clickAboutButton(){
        val intent = Intent(this,AboutActivity::class.java)
        startActivity(intent)
    }

    fun clickExitButton(){
        finish()
    }

}
