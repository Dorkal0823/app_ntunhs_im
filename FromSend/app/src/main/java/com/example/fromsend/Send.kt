package com.example.fromsend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Send : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        var View_Account = findViewById<TextView>(R.id.text_Account)
        var View_Password = findViewById<TextView>(R.id.text_Password)
        var View_Email = findViewById<TextView>(R.id.text_Email)
        var View_BD = findViewById<TextView>(R.id.text_Bith)
        var View_Name = findViewById<TextView>(R.id.text_Name)
        var View_City = findViewById<TextView>(R.id.text_City)
        var View_Gender = findViewById<TextView>(R.id.text_Gender)
        var View_Vehicle = findViewById<TextView>(R.id.text_Vehicle)
        var Btn_Back = findViewById<Button>(R.id.Btn_Back)

        var text_Account = intent.getBundleExtra("key")?.getString("account").toString()
        var text_Password = intent.getBundleExtra("key")?.getString("Password").toString()
        var text_Email = intent.getBundleExtra("key")?.getString("email").toString()
        var text_BD = intent.getBundleExtra("key")?.getString("BD").toString()
        var text_Name = intent.getBundleExtra("key")?.getString("name").toString()
        var text_City = intent.getBundleExtra("key")?.getString("city").toString()
        var text_Gender = intent.getBundleExtra("key")?.getString("gender").toString()
        var text_Vehicle = intent.getBundleExtra("key")?.getString("vehicle").toString()

        View_Account.setText("帳號："+text_Account)
        View_Password.setText("密碼："+text_Password)
        View_Email.setText("信箱："+text_Email)
        View_BD.setText("生日："+text_BD)
        View_Name.setText("姓名："+text_Name)
        View_City.setText("城市："+text_City)
        View_Gender.setText("性別："+text_Gender)
        View_Vehicle.setText("興趣："+text_Vehicle)

        Btn_Back.setOnClickListener {
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