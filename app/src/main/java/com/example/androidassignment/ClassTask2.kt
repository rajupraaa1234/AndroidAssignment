package com.example.androidassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ClassTask2 : AppCompatActivity() {

    lateinit var btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_task2)
        btn = findViewById(R.id.bt_change_color);
        btn.setOnClickListener {
            btn.isSelected = !btn.isSelected
        }
    }
}