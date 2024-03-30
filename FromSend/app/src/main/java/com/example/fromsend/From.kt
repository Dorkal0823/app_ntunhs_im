package com.example.fromsend

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import java.util.Calendar

class From : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from)
        val spnCity = findViewById<Spinner>(R.id.spnCity)
        val adapter = ArrayAdapter.createFromResource(
            this, R.array.city,
            android.R.layout.simple_spinner_dropdown_item
        )
        val RadGroup_Gender = findViewById<RadioGroup>(R.id.RadGroup_Gender)
        val Radbtn_man = findViewById<RadioButton>(R.id.RadBtn_man)
        val Radbtn_woman = findViewById<RadioButton>(R.id.RadBtn_woman)
        val Radbtn_Empty = findViewById<RadioButton>(R.id.RadBtn_empty)
        val Radbtn_Apache = findViewById<RadioButton>(R.id.RadBtn_Apache)
        val ChB_Pingpong = findViewById<CheckBox>(R.id.ChB_Pingpong)
        val ChB_Badminton = findViewById<CheckBox>(R.id.ChB_Badminton)
        val ChB_Swim = findViewById<CheckBox>(R.id.ChB_Swim)
        val Btn_Send = findViewById<Button>(R.id.Btn_send)
        val Text_BD = findViewById<EditText>(R.id.Text_BD)
        val Text_Account = findViewById<EditText>(R.id.Text_Account)
        val Text_Password = findViewById<EditText>(R.id.Text_Password)
        val Text_Email = findViewById<EditText>(R.id.Text_Email)
        val Text_Name = findViewById<EditText>(R.id.Text_Name)
        spnCity.adapter = adapter

        spnCity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        Text_BD.setOnClickListener {
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, { _, year, month, day ->
                run {
                    var format = "${setDateFormat(year, month, day)}"
                    Text_BD.setText(format)
                }
            }, year, month, day).show()
        }

        var gender: String = ""
        RadGroup_Gender.setOnCheckedChangeListener { _, checkedId ->
            gender = when (checkedId) {
                R.id.RadBtn_man -> Radbtn_man.text.toString()
                R.id.RadBtn_woman -> Radbtn_woman.text.toString()
                R.id.RadBtn_empty -> Radbtn_Empty.text.toString()
                R.id.RadBtn_Apache -> Radbtn_Apache.text.toString()
                else -> "I don't Know"
            }
        }


        Btn_Send.setOnClickListener {
            var msgChB = ""

            if (ChB_Pingpong.isChecked) {
                msgChB += ChB_Pingpong.text.toString()
            }
            if (ChB_Badminton.isChecked) {
                if (msgChB.isNotEmpty()) {
                    msgChB += " "
                }
                msgChB += ChB_Badminton.text.toString()
            }
            if (ChB_Swim.isChecked) {
                if (msgChB.isNotEmpty()) {
                    msgChB += " "
                }
                msgChB += ChB_Swim.text.toString()
            }


            val account = Text_Account.text.toString()
            val password = Text_Password.text.toString()
            val email = Text_Email.text.toString()
            val BD = Text_BD.text.toString()
            val name = Text_Name.text.toString()
            val city = spnCity.selectedItem.toString()
            val vehicle = msgChB


            val bundle = Bundle()
            bundle.putString("account", account)
            bundle.putString("password", password)
            bundle.putString("email", email)
            bundle.putString("BD", BD)
            bundle.putString("name", name)
            bundle.putString("city", city)
            bundle.putString("gender", gender)
            bundle.putString("vehicle", vehicle)

            if (account.isEmpty() || password.isEmpty() || email.isEmpty() || BD.isEmpty() || name.isEmpty() || city == "請選擇縣市" || vehicle.isEmpty()) {
                Toast.makeText(this, "請將資料輸入完整", Toast.LENGTH_SHORT).show()
            } else {
                val secondIntent = Intent(this, Send::class.java).apply {
                    putExtra("key", bundle)
                }
                startActivity(secondIntent)
            }
        }

    }
    private fun setDateFormat(year: Int,month: Int,day:Int):String{
        return "$year-${month + 1}-$day"
    }
}

