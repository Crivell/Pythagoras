@file:Suppress("UsePropertyAccessSyntax")

package com.crivell.calculator

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var simpleButton : Button
    lateinit var advanceButton : Button
    lateinit var aboutButton : Button
    lateinit var exitButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()

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
