package com.example.androidassignment.BroadCastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class PowerConnectionBR internal constructor(var textView: TextView, extext: TextView,progressPar : ProgressBar) :
    BroadcastReceiver() {
    var extxt: TextView
    lateinit var proBar : ProgressBar
    override fun onReceive(context: Context, intent: Intent) {
        Log.i("MYChargingTab", "Charging Connected")
        val ifilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus = context.registerReceiver(null, ifilter)

        // Are we charging / charged?
        val status = batteryStatus!!.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL

        val level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        if (flag == false) {
            flag = true
            level1 = level
        } else {
            if (level1 < level) {
                level2 = level
                level1 = level
                date2 = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
                Log.i("MYChargingTab", "time : " + date2)
                Log.i("MYChargingTab", "level 2 : " + level2)
                try {
                    val timediff = getDifferenceTime(date1, date2)
                    date1 = date2
                   // Log.i("MYChargingTab", "Diff :$timediff")
                    val timeEstimate = findExpactedTime(timediff, level2)
                   // Log.i("MYChargingTab", "Estimate :  $timeEstimate")
                    extxt.text = timeEstimate
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }
        }
        textView.text = "Charging Status : $level%"
        proBar.setProgress(level)
        if (intent.action == Intent.ACTION_POWER_CONNECTED) {
            Toast.makeText(context, "The device is charging", Toast.LENGTH_SHORT).show()
        } else if (intent.action == Intent.ACTION_POWER_DISCONNECTED) {
            Toast.makeText(context, "The device is not charging", Toast.LENGTH_SHORT).show()
        }
    }

    private fun findExpactedTime(timediff: Long, level2: Int): String {
        val time = timediff * Math.abs(100 - level2)
        return changeSecondToString(time)
    }

    @Throws(ParseException::class)
    private fun getDifferenceTime(time1: String?, time2: String?): Long {
        val simpleDateFormat = SimpleDateFormat("HH:mm:ss")
        val date1 = simpleDateFormat.parse(time1)
        val date2 = simpleDateFormat.parse(time2)

        // Calculating the difference in milliseconds
        val differenceInMilliSeconds = Math.abs(date2.time - date1.time)
        return differenceInMilliSeconds / 1000
    }

    companion object {
        var date1: String? = null
        var date2: String? = null
        var level1 = 0
        var level2 = 0
        var flag: Boolean = false
        fun changeSecondToString(timeInSeconds: Long): String {
            val hours = (timeInSeconds / 3600).toInt()
            val secondsLeft = (timeInSeconds - hours * 3600).toInt()
            val minutes = secondsLeft / 60
            val seconds = secondsLeft - minutes * 60
            var formattedTime = ""
            if (hours < 10) formattedTime += "0"
            formattedTime += "$hours:"
            if (minutes < 10) formattedTime += "0"
            formattedTime += "$minutes:"
            if (seconds < 10) formattedTime += "0"
            formattedTime += seconds
            return formattedTime
        }
    }

    init {
        date1 = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        flag = false
        extxt = extext
        proBar = progressPar
        Log.i("MYChargingTab", "Charging Connected Constructor " + date1)
    }
}