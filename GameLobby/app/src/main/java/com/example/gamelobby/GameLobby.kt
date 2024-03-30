package com.example.gamelobby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GameLobby : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamelobby)
        var Btn_GuessNumber = findViewById<Button>(R.id.Btn_GuessNumber)
        var Btn_PPS = findViewById<Button>(R.id.Btn_PSS)


        Btn_GuessNumber.setOnClickListener{
            var bundle = Bundle()
            var seconIntent = Intent(this, GuessNumber::class.java)
            seconIntent.putExtra("key",bundle)
            startActivity(seconIntent)
        }

        Btn_PPS.setOnClickListener{
            var bundle = Bundle()
            var seconIntent = Intent(this, PaperScissorsStone::class.java)
            seconIntent.putExtra("key",bundle)
            startActivity(seconIntent)
        }
    }
}