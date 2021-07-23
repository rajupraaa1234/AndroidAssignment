package com.example.androidassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var textView:TextView
    lateinit var popup : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){
        textView = findViewById(R.id.second)
        popup = findViewById(R.id.third)
    }

    fun onClickHandler(view : View){
        when(view.id){
            R.id.first->{openFirstTask()}
            R.id.second->{setColorOfBackColor()}
            R.id.third->{openPopup()}
            R.id.fourth->{openForthTask()}
        }
    }

    private fun openForthTask() {
        var intent : Intent
        intent = Intent(this,FourthTask::class.java)
        startActivity(intent)
    }

    private fun openPopup() {
        popup.setOnClickListener(View.OnClickListener {
            val popupMenu: PopupMenu = PopupMenu(this,popup)
            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.one ->
                        Toast.makeText(this@MainActivity, "You Clicked one : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.two ->
                        Toast.makeText(this@MainActivity, "You Clicked two: " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.three ->
                        Toast.makeText(this@MainActivity, "You Clicked three: " + item.title, Toast.LENGTH_SHORT).show()
                }
                true
            })
            popupMenu.show()
        })
    }

    private fun setColorOfBackColor() {
        textView.setBackgroundResource(R.drawable.green_back);
    }

    private fun openFirstTask() {
        var intent : Intent
        intent = Intent(this,FirstTaskActivity::class.java)
        startActivity(intent)
    }
}