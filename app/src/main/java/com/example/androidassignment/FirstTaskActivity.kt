package com.example.androidassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class FirstTaskActivity : AppCompatActivity() {

    lateinit var edittext : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_task)
        init()
    }

    fun init(){
        edittext = findViewById(R.id.password)
    }

    fun FisrtOnClick(view: View){
         when(view.id){
             R.id.passbtn->{
                 edittext.setSelectAllOnFocus(true);
                 edittext.selectAll();
             }
         }
    }
}