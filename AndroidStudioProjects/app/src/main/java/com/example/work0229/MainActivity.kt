package com.example.work0229

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TextView = findViewById<TextView>(R.id.TextView)
        val guess_button = findViewById<Button>(R.id.guess_button)
        val reset_button = findViewById<Button>(R.id.reset_button)
        val editText = findViewById<EditText>(R.id.editText)
        var validate_num: Int
        var secret: Int = Random().nextInt(10) + 1


        guess_button.setOnClickListener {
            TextView.text = editText.text
            validate_num = editText.text.toString().toInt() - secret
            var ans_str: String = "猜對了！"
            if (validate_num > 0) {
                ans_str = "猜小一點"
            } else if (validate_num < 0) {
                ans_str = "猜大一點"
            }
            TextView.text = ans_str
        }
        reset_button.setOnClickListener {
            secret = Random().nextInt(10) + 1
            TextView.text = "再猜一次"
        }
    }
}