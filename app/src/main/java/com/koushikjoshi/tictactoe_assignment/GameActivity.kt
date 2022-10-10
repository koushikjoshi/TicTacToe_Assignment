package com.koushikjoshi.tictactoe_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class GameActivity : AppCompatActivity() {

//    Let us assume 1 = Player X and 0 = Player O

    var curr_player = 1
    var gameStatus = true
    var count = 0
    var gameState = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    var winningPositions = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

    }

    fun dropIn(view: View){

        val counter = view as ImageView
        val txt = findViewById<TextView>(R.id.winner1)
        val btn = findViewById<Button>(R.id.button)

        txt.visibility = View.INVISIBLE
        btn.visibility = View.INVISIBLE

        //understand
        val tappedcounter = counter.tag.toString().toInt()
        if (gameState[tappedcounter] == 2 && gameStatus) {
            if (curr_player == 1) {
                counter.setImageResource(R.drawable.ximage)
                curr_player = 0
                count++
                gameState[tappedcounter] = 1
            } else {
                counter.setImageResource(R.drawable.oimage)
                curr_player = 1
                count++
                gameState[tappedcounter] = 0
            }
            counter.translationY = -1000f
            counter.animate().translationYBy(1000f).rotationY(1800f).duration = 1000
            for (winningposition in winningPositions) {
                if (gameState[winningposition[0]] == gameState[winningposition[1]] && gameState[winningposition[1]] == gameState[winningposition[2]] && gameState[winningposition[0]] != 2
                ) {
                    if (gameState[winningposition[0]] == 0) txt.text =
                        "O Player Wins" else if (gameState[winningposition[0]] == 1
                    ) txt.text = "X Player Wins"
                    btn.visibility = View.VISIBLE
                    txt.visibility = View.VISIBLE
                    gameStatus = false
                }
            }
        }
        if (gameStatus && count == 9) {
            txt.text = "DRAW"
            txt.visibility = View.VISIBLE
            btn.visibility = View.VISIBLE
            gameStatus = false
        }

    }

    fun playAgain(view: View?) {
        curr_player = 1
        gameStatus = true
        count= 0
        val txt = findViewById<TextView>(R.id.winner1)
        val btn = findViewById<Button>(R.id.button)
        val gridLayout =
            findViewById<GridLayout>(R.id.gridLayout)
        for (i in gameState.indices) {
            gameState[i] = 2
        }
        btn.visibility = View.INVISIBLE
        txt.visibility = View.INVISIBLE
        for (i in 0 until gridLayout.childCount) {
            (gridLayout.getChildAt(i) as ImageView).setImageResource(0) //p t n
        }
    }

}