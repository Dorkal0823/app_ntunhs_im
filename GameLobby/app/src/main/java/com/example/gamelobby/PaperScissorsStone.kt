package com.example.gamelobby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class PaperScissorsStone : AppCompatActivity() {
    //private lateinit var text_Com: TextView
    private lateinit var text_Result: TextView
    private lateinit var imbtn_Scissors: ImageButton
    private lateinit var imbtn_Stone: ImageButton
    private lateinit var imbtn_Paper: ImageButton
    private lateinit var image_Com: ImageView
    private lateinit var Btn_Back: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper_scissors_stone)
        //text_Com = findViewById(R.id.text_Com)
        image_Com = findViewById(R.id.image_Com)
        text_Result = findViewById(R.id.text_Result)
        imbtn_Scissors = findViewById(R.id.imbtn_Scissors)
        imbtn_Stone = findViewById(R.id.imbtn_Stone)
        imbtn_Paper = findViewById(R.id.imbtn_Paper)
        Btn_Back = findViewById(R.id.Btn_Back)


        imbtn_Scissors.setOnClickListener {
            playGame(Choice.SCISSORS)
        }

        imbtn_Stone.setOnClickListener {
            playGame(Choice.ROCK)
        }

        imbtn_Paper.setOnClickListener {
            playGame(Choice.PAPER)
        }
        Btn_Back.setOnClickListener {
            finish()
        }
    }

    fun getChoiceString(choice: Choice): Int {
        return when (choice) {
            Choice.SCISSORS -> R.string.scissors
            Choice.ROCK -> R.string.rock
            Choice.PAPER -> R.string.paper
        }
    }

    enum class Choice {
        SCISSORS, ROCK, PAPER
    }

    fun playGame(playerChoice: Choice) {
        val choices = Choice.values()
        val computerChoice = choices[Random().nextInt(choices.size)]
        image_Com.setImageResource(getChoiceDrawable(computerChoice))
        when {
            playerChoice == computerChoice -> {
                //text_Com.setText(getChoiceString(computerChoice))
                text_Result.setText(R.string.draw)
            }

            (playerChoice == Choice.SCISSORS && computerChoice == Choice.PAPER) ||
                    (playerChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
                    (playerChoice == Choice.PAPER && computerChoice == Choice.ROCK) -> {
                //text_Com.setText(getChoiceString(computerChoice))
                text_Result.setText(R.string.win)
            }

            else -> {
                //text_Com.setText(getChoiceString(computerChoice))
                text_Result.setText(R.string.lose)
            }
        }

    }
    fun getChoiceDrawable(choice: Choice): Int {
        return when (choice) {
            Choice.SCISSORS -> R.drawable.scissor
            Choice.ROCK -> R.drawable.rock
            Choice.PAPER -> R.drawable.paper
        }
    }
    var lasttime: Long = 0
    override fun finish() {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lasttime > 3 * 1000) {
            lasttime = currentTime
            Toast.makeText(this, "再按一下離開", Toast.LENGTH_SHORT).show()
        } else {
            super.finish()
        }
    }
}