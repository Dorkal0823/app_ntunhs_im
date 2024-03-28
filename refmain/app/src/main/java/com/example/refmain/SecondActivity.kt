package com.example.refmain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btn_BacktoFirst = findViewById<Button>(R.id.btn_Backtofirst)
        var txt_test = findViewById<TextView>(R.id.txt_Test)
        val text = intent.getBundleExtra("key")?.getString("name").toString()

        txt_test.setText(text)

        btn_BacktoFirst.setOnClickListener {
            finish()
        }
    }
    var lasttime: Long = 0
    override fun finish(){
        val currentTime = System.currentTimeMillis()
        if(currentTime - lasttime > 3 * 1000){
            lasttime = currentTime
            Toast.makeText(this, "再按一下離開",Toast.LENGTH_SHORT).show()
        }else{
            super.finish()
        }
    }
}