package com.eunma.sinsamguide.ui.alarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.eunma.sinsamguide.databinding.FragmentAlarmBinding
import java.util.*

class AlarmFragment : Fragment() {

    private var _binding: FragmentAlarmBinding? = null
    private val binding get() = _binding!!
    private lateinit var alarmViewModel: AlarmViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        alarmViewModel = ViewModelProvider(this).get(AlarmViewModel::class.java)
        _binding = FragmentAlarmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 스위치 상태 복원
        val switches = arrayOf(binding.alarm1Switch, binding.alarm2Switch, binding.alarm3Switch, binding.alarm4Switch)
        switches.forEach { switch ->
            switch.isChecked = alarmViewModel.getSwitchState(switch.id)
        }

        binding.alarm1Switch.setOnCheckedChangeListener { _, isChecked ->
            // 클라우드 메시지 알림 설정
            alarmViewModel.handleCloudMessageAlarm(isChecked)
            alarmViewModel.saveSwitchState(binding.alarm1Switch.id, isChecked)
        }

        binding.alarm2Switch.setOnCheckedChangeListener { _, isChecked ->
            // 로컬 알림 설정 UI 표시
            alarmViewModel.handleLocalAlarmSettings(isChecked)
            alarmViewModel.saveSwitchState(binding.alarm2Switch.id, isChecked)
        }

        binding.alarm3Switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val calendar = Calendar.getInstance().apply {
                    set(Calendar.HOUR_OF_DAY, 22)
                    set(Calendar.MINUTE, 0)
                    set(Calendar.SECOND, 0)
                }
                alarmViewModel.setLocalAlarm(requireContext(), calendar.timeInMillis, "잠들기 전에 모든 숙제를 했는지 확인해요~")
            } else {
                alarmViewModel.cancelLocalAlarm(requireContext())
            }
            alarmViewModel.saveSwitchState(binding.alarm3Switch.id, isChecked)
        }

        binding.alarm4Switch.setOnCheckedChangeListener { _, isChecked ->
            // 클라우드 메시지 알림 설정
            alarmViewModel.handleCloudMessageAlarm(isChecked)
            alarmViewModel.saveSwitchState(binding.alarm4Switch.id, isChecked)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
