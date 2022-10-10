package com.koushikjoshi.tictactoe_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

//    Declaring views
    private lateinit var personXText: EditText
    private lateinit var personOText: EditText
    private lateinit var startBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Initializing views to UI elements
        personXText = findViewById(R.id.playerXName)
        personOText = findViewById(R.id.playerOName)
        startBtn = findViewById(R.id.startButton)

//        Adding button functionality
        startBtn.setOnClickListener {
//            only go to next page if both players' names are added

            if(personXText.text.toString().isNotEmpty() && personOText.text.toString().isNotEmpty()){

                var nameX: String = personXText.text.toString()
                var nameO: String = personOText.text.toString()
                goToNextPage(nameX, nameO)

            }
//            If the condition is not met, display a toast message
            else{

                Toast.makeText(this, "Please enter names for both players", Toast.LENGTH_SHORT).show()

            }

        }

    }

// function to take the app to the next (game) page
    private fun goToNextPage(nameX: String, nameO: String) {

        var intent: Intent = Intent(this, GameActivity::class.java)
        intent.putExtra("nameX", nameX)
        intent.putExtra("nameO", nameO)
        startActivity(intent)

    }
}