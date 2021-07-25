package com.example.androidassignment

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidassignment.BroadCastReceiver.PowerConnectionBR

class NinthTask : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var extxt: TextView
    lateinit var progressBar : ProgressBar
    var receiver: PowerConnectionBR? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ninth_task)
        init()
    }

    private fun init(){
        progressBar = findViewById(R.id.progressBar)
        textView = findViewById(R.id.betper)
        extxt = findViewById(R.id.expatedtime)
        receiver = PowerConnectionBR(textView,extxt,progressBar)
        val ifilter = IntentFilter()
        ifilter.addAction(Intent.ACTION_POWER_CONNECTED)
        ifilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        ifilter.addAction(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(receiver, ifilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }
}