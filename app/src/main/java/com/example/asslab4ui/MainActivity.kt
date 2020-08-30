package com.example.asslab4ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    var subject:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val subjectArray = resources.getStringArray(R.array.subjectName_arry)
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,subjectArray)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }
    fun showTimePickerDialog(v:View){
        val newTimePickerFragment = DatePickerFragment()
        newTimePickerFragment.show(supportFragmentManager, "Date Picker")
    }


    fun showDetail(view: View){
        val selectgroup :Int = sexGroup.checkedRadioButtonId
        var gender = ""
        try {
            var radioButtonChecked : RadioButton = findViewById(selectgroup)
            gender = radioButtonChecked.text as String
        }catch (t: Throwable){
            gender = ""
        }

        text_show.text = "Name: ${edit_id.text}\nPassword: ${edit_password.text}\nGender: $gender\nBirthday: ${text_date.text}"
    }
    fun reset(v: View){
        edit_id.text.clear()
        edit_password.text.clear()
        text_date.text="mm/dd/yy"
        edit_email.text.clear()
        text_show.text = "Show detail"
        sexGroup.clearCheck()
    }
}