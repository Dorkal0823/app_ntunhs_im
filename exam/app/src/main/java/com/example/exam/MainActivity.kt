package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edit_phone = findViewById<EditText>(R.id.edit_Phone)
        val spin_p = findViewById<Spinner>(R.id.spinner_p)
        val spin_c = findViewById<Spinner>(R.id.spinner_c)
        val btn_send = findViewById<Button>(R.id.btn_send)
        val chb_cc = findViewById<CheckBox>(R.id.chp_cche)
        val chb_cf = findViewById<CheckBox>(R.id.chp_cf)
        val adapter = ArrayAdapter.createFromResource(
            this, R.array.p_number,
            android.R.layout.simple_spinner_dropdown_item
        )
        spin_p.adapter = adapter
        spin_c.adapter = adapter


        spin_p.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>,
                p1: View,
                p2: Int,
                p3: Long
            ) {
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        spin_c.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>,
                p1: View,
                p2: Int,
                p3: Long
            ) {
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    btn_send.setOnClickListener{
        val phone = edit_phone.text.toString()
        val spin_p = spin_p.selectedItem.toString()
        val spin_c = spin_c.selectedItem.toString()
        var msgChB = ""

        if (chb_cc.isChecked) {
            msgChB += chb_cc.text.toString()
        }
        if (chb_cf.isChecked) {
            if (msgChB.isNotEmpty()) {
                msgChB += "、"
            }
            msgChB += chb_cf.text.toString()
        }
        val bundle = Bundle()
        bundle.putString("phone",phone)
        bundle.putString("spin_p",spin_p)
        bundle.putString("spin_c",spin_c)
        bundle.putString("chb",msgChB)
        Log.e(Companion.TAG,"電話："+phone +" "+ "大人：" + spin_p+" " + "小孩："+spin_c+" " + "需求：" + msgChB)
        if(phone.isEmpty() || spin_c == "請選擇人數" || spin_p == "請選擇人數"){
            Toast.makeText(this, "請將資料輸入完整", Toast.LENGTH_SHORT).show()
        }else{
            val secoundintent =Intent(this, send::class.java).apply {
                putExtra("key",bundle)
            }
                startActivity(secoundintent)
        }
    }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}