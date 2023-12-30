package com.eunma.sinsamguide.ui.alarm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import java.util.*
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.messaging.FirebaseMessaging

class AlarmViewModel : ViewModel() {

    private val switchStates = mutableMapOf<Int, Boolean>()

    fun saveSwitchState(context: Context, switchId: Int, state: Boolean) {
        val sharedPref = context.getSharedPreferences("AlarmSettings", Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putBoolean(switchId.toString(), state)
            apply()
        }
    }

    fun getSwitchState(context: Context, switchId: Int): Boolean {
        val sharedPref = context.getSharedPreferences("AlarmSettings", Context.MODE_PRIVATE)
        return sharedPref.getBoolean(switchId.toString(), false)
    }

    fun saveSwitchStateToFirebase(switchId: Int, state: Boolean, userId: String) {
        val database = FirebaseDatabase.getInstance().reference
        database.child("users").child(userId).child("switchStates").child(switchId.toString()).setValue(state)
    }

    fun getSwitchStateFromFirebase(switchId: Int, userId: String, callback: (Boolean) -> Unit) {
        val database = FirebaseDatabase.getInstance().reference
        database.child("users").child(userId).child("switchStates").child(switchId.toString())
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val state = dataSnapshot.getValue(Boolean::class.java) ?: false
                    callback(state)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle error case
                }
            })
    }

    fun handleCloudMessageAlarm(isEnabled: Boolean, userId: String) {
        if (isEnabled) {
            // 메시지 전송 로직
            // 예: FCM을 이용해 특정 사용자 또는 토픽에 메시지를 보냄
            FirebaseMessaging.getInstance().subscribeToTopic("some_topic")
        } else {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("some_topic")
        }
    }
    fun handleLocalAlarmSettings(isEnabled: Boolean) {
        // 로컬 알림 설정 UI 노출 또는 숨김
    }

    fun setLocalAlarm(context: Context, timeInMillis: Long, message: String) {
        // 로컬 알림 설정
    }

    fun cancelLocalAlarm(context: Context) {
        // 로컬 알림 해제
    }
    fun setWeeklyAlarms(context: Context, isEnabled: Boolean) {
        if (isEnabled) {
            val alarmSchedule = mapOf(
                Calendar.MONDAY to Pair(19, 30),  // 월요일 19시 30분
                Calendar.TUESDAY to Pair(22, 0),   // 화요일 22시
                // 수요일은 없음
                Calendar.THURSDAY to Pair(20, 0), // 목요일 20시
                // 한중/적벽/백마 22시
                Calendar.FRIDAY to Pair(22, 0),   // 금요일 22시
                Calendar.SATURDAY to Pair(12, 0)  // 토요일 12시
                // 군단전 22시
            )

            alarmSchedule.forEach { (dayOfWeek, time) ->
                setLocalAlarmForDay(context, dayOfWeek, time.first, time.second)
            }
        } else {
            cancelAllAlarms(context) // 모든 알람 취소
        }
    }
    private fun setLocalAlarmForDay(context: Context, dayOfWeek: Int, hour: Int, minute: Int) {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.DAY_OF_WEEK, dayOfWeek)
            set(Calendar.HOUR_OF_DAY, hour - 1) // 1시간 전
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
        }
        // 여기에 로컬 알람 설정 로직 추가
    }

    private fun cancelAllAlarms(context: Context) {
        // 여기에 모든 로컬 알람 취소 로직 추가
    }
}
