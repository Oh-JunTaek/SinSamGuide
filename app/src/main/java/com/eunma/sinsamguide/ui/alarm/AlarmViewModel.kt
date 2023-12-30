package com.eunma.sinsamguide.ui.alarm

import android.content.Context
import androidx.lifecycle.ViewModel
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
                Calendar.MONDAY to Pair(19, 30) to "묘우탈보",
                Calendar.TUESDAY to Pair(22, 0) to "안문전투",
                // 수요일은 없음
                Calendar.THURSDAY to Pair(20, 0) to "유적정봉",
                Calendar.THURSDAY to Pair(22, 30) to "한중/적벽/백마",
                Calendar.FRIDAY to Pair(22, 0) to "장안쟁탈전",
                Calendar.SATURDAY to Pair(12, 0) to "남만침입",
                Calendar.SATURDAY to Pair(22, 0) to "군단전"
            )

            alarmSchedule.forEach { (time, event) ->
                setLocalAlarmForEvent(context, time.first, time.second, event)
            }
        } else {
            cancelAllAlarms(context) // 모든 알람 취소
        }
    }

    private fun setLocalAlarmForEvent(context: Context, dayOfWeek: Int, hourMinute: Pair<Int, Int>, event: String) {
        val (hour, minute) = hourMinute
        val calendar = Calendar.getInstance().apply {
            set(Calendar.DAY_OF_WEEK, dayOfWeek)
            set(Calendar.HOUR_OF_DAY, hour - 1) // 1시간 전
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
        }

        val message = "$event 이(가) 1시간 뒤에 시작됩니다. 늦지 않게 준비하세요."
        setLocalAlarm(context, calendar.timeInMillis, message)
    }

    private fun cancelAllAlarms(context: Context) {
        // 여기에 모든 로컬 알람 취소 로직 추가
    }
}
