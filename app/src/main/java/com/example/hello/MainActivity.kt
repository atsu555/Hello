package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle

import android.view.View
import android.widget.Button
import android.widget.TextView

//import java.util.*
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCurrent = findViewById<Button>(R.id.btnCurrent)
            btnCurrent.setOnClickListener {
            val txtResult = findViewById<TextView>(R.id.txtResult)
            txtResult.text = Date().toString()
        }
    }

    // 画面が破棄される前に状態を保存
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val txtResult = findViewById<TextView>(R.id.txtResult)
        outState.putString("txtResult", txtResult.text.toString())
    }

    // 画面が復元される前に状態を取り出し
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val txtResult = findViewById<TextView>(R.id.txtResult)
        txtResult.text = savedInstanceState.getString("txtResult")
    }

}