package com.eunma.sinsamguide.ui.alarm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.android.material.switchmaterial.SwitchMaterial
import java.util.*

class AlarmViewModel : ViewModel() {

    private val switchStates = mutableMapOf<Int, Boolean>()

    fun getSwitchState(switchId: Int): Boolean {
        return switchStates[switchId] ?: false
    }

    fun saveSwitchState(switchId: Int, state: Boolean) {
        switchStates[switchId] = state
        // 여기에 사용자 설정을 저장하는 로직을 추가 (예: Shared Preferences, Firebase 등)
    }

    fun handleCloudMessageAlarm(isEnabled: Boolean) {
        // 클라우드 메시지 알림 설정 또는 해제
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
}
