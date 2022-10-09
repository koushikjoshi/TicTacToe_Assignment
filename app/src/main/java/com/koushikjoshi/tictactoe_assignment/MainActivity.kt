package com.koushikjoshi.tictactoe_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var personXText: EditText
    private lateinit var personOText: EditText
    private lateinit var startBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personXText = findViewById(R.id.playerXName)
        personOText = findViewById(R.id.playerOName)

    }
}