package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class send : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        val btn_Back = findViewById<Button>(R.id.btn_back)
        val view_phone = findViewById<TextView>(R.id.view_phone)
        val view_p = findViewById<TextView>(R.id.view_p)
        val view_c = findViewById<TextView>(R.id.view_C)

        var text_phone =intent.getBundleExtra("key")?.getString("phone").toString()
        var text_p =intent.getBundleExtra("key")?.getString("spin_p").toString()
        var text_c =intent.getBundleExtra("key")?.getString("spin_c").toString()
        var text_CC = intent.getBundleExtra("key")?.getString("chb").toString()
        view_phone.setText("訂位電話：" + text_phone)
        view_p.setText("訂位人數：" + text_p + "大" + text_c + "小")
        if(text_CC.isNotEmpty()){
            view_c.setText("需要：" + text_CC)
        }else{
            view_c.setText("")
        }
        btn_Back.setOnClickListener {
            finish()
        }
    }
    var lasttime: Long = 0
    override fun finish(){
        val currentTime = System.currentTimeMillis()
        if(currentTime - lasttime > 3 * 1000){
            lasttime = currentTime
            Toast.makeText(this, "再按一下離開", Toast.LENGTH_SHORT).show()
        }else{
            super.finish()
        }
    }
}