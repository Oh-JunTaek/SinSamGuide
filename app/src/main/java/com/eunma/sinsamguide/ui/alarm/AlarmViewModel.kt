package com.eunma.sinsamguide.ui.alarm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.androidbrowserhelper.trusted.NotificationUtils

class AlarmViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "알림 설정"
    }
    val text: LiveData<String> = _text

    fun setAlarm(context: Context, timeInMillis: Long) {
        val notificationUtils = NotificationUtils(context)
        notificationUtils.createNotificationChannel("channelId", "Alarm", "Daily Alarm")
        val notification = notificationUtils.buildNotification("channelId", "Alarm", "This is your alarm.")
        notificationUtils.scheduleNotification(notification, timeInMillis)
    }
}