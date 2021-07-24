package com.example.androidassignment.BroadCastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.SyncStateContract
import android.text.format.DateFormat
import com.example.androidassignment.R
import com.example.androidassignment.services.AlarmService

import com.foodiedev.setrepetitiveexactalarm.util.Constants
import com.foodiedev.setrepetitiveexactalarm.util.Constants.ACTION_SET_REPETITIVE_EXACT
import io.karn.notify.Notify

import timber.log.Timber
import java.lang.invoke.MethodHandles.constant
import java.util.*
import java.util.concurrent.TimeUnit

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val timeInMillis = intent.getLongExtra(Constants.EXTRA_EXACT_ALARM_TIME, 0L)
        when (intent.action) {
            Constants.ACTION_SET_EXACT -> {
                buildNotification(context, context.getString(R.string.wishes), convertDate(timeInMillis))
            }

                Constants.ACTION_SET_REPETITIVE_EXACT -> {
                setRepetitiveAlarm(AlarmService(context))
                buildNotification(context, context.getString(R.string.wishes), convertDate(timeInMillis))
            }
        }
    }

    private fun buildNotification(context: Context, title: String, message: String) {
        Notify
            .with(context)
            .content {
                this.title = title
                text = context.getString(R.string.wishing_bday)
                //text = "I got triggered at - $message"
            }
            .show()
    }

    private fun setRepetitiveAlarm(alarmService: AlarmService) {
        val cal = Calendar.getInstance().apply {
            this.timeInMillis = timeInMillis + TimeUnit.DAYS.toMillis(7)
            Timber.d("Set alarm for next week same time - ${convertDate(this.timeInMillis)}")
        }
        alarmService.setRepetitiveAlarm(cal.timeInMillis)
    }

    private fun convertDate(timeInMillis: Long): String =
        DateFormat.format("dd/MM/yyyy hh:mm:ss", timeInMillis).toString()

}