package com.example.refmain

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_ChangeActivity = findViewById<Button>(R.id.btn_ChangeActivity)
        val btn_OpenBrowser = findViewById<Button>(R.id.btn_OpenBrowser)
        var edt_Name = findViewById<EditText>(R.id.edt_Name)

        btn_ChangeActivity.setOnClickListener{
            var bundle = Bundle()
            var name = edt_Name.text.toString()
            if (name.isEmpty()){
                Toast.makeText(this, "請輸入名字", Toast.LENGTH_SHORT).show()
            }else{
                bundle.putString("name",name)
                var seconIntent = Intent(this, SecondActivity::class.java)
                seconIntent.putExtra("key",bundle)
                startActivity(seconIntent)
            }
        }

        btn_OpenBrowser.setOnClickListener{
            var seconIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(seconIntent)
        }
    }
}