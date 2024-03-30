package com.example.gamelobby

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Random


class GuessNumber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_number)

        val TextView = findViewById<TextView>(R.id.TextView)
        val guess_button = findViewById<Button>(R.id.guess_button)
        val reset_button = findViewById<Button>(R.id.reset_button)
        val editText = findViewById<EditText>(R.id.editText)
        var validate_num: Int
        var secret: Int = Random().nextInt(1000) + 1
        var Btn_Back = findViewById<Button>(R.id.Btn_Back)


        guess_button.setOnClickListener {
            val guessText = editText.text.toString()
            if (guessText.isNotEmpty()) {
                try {
                    val guessNum = guessText.toInt()
                    validate_num = guessNum - secret
                    var ans_str: String = "猜對了！"
                    if (validate_num > 0) {
                        ans_str = "猜小一點"
                    } else if (validate_num < 0) {
                        ans_str = "猜大一點"
                    }
                    TextView.text = ans_str
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "請輸入有效的數字", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "請輸入一個數字", Toast.LENGTH_SHORT).show()
            }
        }

        reset_button.setOnClickListener {
            secret = Random().nextInt(1000) + 1
            TextView.text = "再猜一次"
        }
        Btn_Back.setOnClickListener {
            finish()
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