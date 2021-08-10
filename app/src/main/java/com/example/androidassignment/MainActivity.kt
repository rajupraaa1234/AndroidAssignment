package com.example.androidassignment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    lateinit var textView:TextView
    lateinit var popup : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        getPermisssion()
    }

    private fun getPermisssion(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
            != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.READ_PHONE_STATE),
                1)
        }
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
            R.id.ninth->{openNinthTask()}
            R.id.Tenth->{openTenthTask()}
        }
    }

    private fun openTenthTask() {
        var intent : Intent
        intent = Intent(this,TenthTask::class.java)
        startActivity(intent)
    }

    private fun openNinthTask() {
        var intent : Intent
        intent = Intent(this,NinthTask::class.java)
        startActivity(intent)
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
        var intent : Intent
        intent = Intent(this,ClassTask2::class.java)
        startActivity(intent)
      //  textView.setBackgroundResource(R.drawable.green_back);
    }

    private fun openFirstTask() {
        var intent : Intent
        intent = Intent(this,FirstTaskActivity::class.java)
        startActivity(intent)
    }
}