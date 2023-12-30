package com.eunma.sinsamguide.ui.alarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.eunma.sinsamguide.databinding.FragmentAlarmBinding

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

        // 사용자 ID (예: 구글 로그인 사용자 ID)
        val userId = "some_user_id"

        binding.alarm2Switch.isChecked = alarmViewModel.getSwitchState(requireContext(), binding.alarm2Switch.id)
        binding.alarm3Switch.isChecked = alarmViewModel.getSwitchState(requireContext(), binding.alarm3Switch.id)

        // 스위치 1과 4의 상태를 Firebase에서 가져옴
        binding.alarm1Switch.setOnCheckedChangeListener { _, isChecked ->
            alarmViewModel.handleCloudMessageAlarm(isChecked, userId)
            alarmViewModel.saveSwitchStateToFirebase(binding.alarm1Switch.id, isChecked, userId)
            showFeedback(isChecked)
        }
        alarmViewModel.getSwitchStateFromFirebase(binding.alarm4Switch.id, userId) { state ->
            binding.alarm4Switch.isChecked = state
        }

        binding.alarm1Switch.setOnCheckedChangeListener { _, isChecked ->
            alarmViewModel.handleCloudMessageAlarm(isChecked, userId)
            alarmViewModel.saveSwitchStateToFirebase(binding.alarm1Switch.id, isChecked, userId)
        }

        binding.alarm2Switch.setOnCheckedChangeListener { _, isChecked ->
            alarmViewModel.saveSwitchState(requireContext(), binding.alarm2Switch.id, isChecked)
            showFeedback(isChecked)
            alarmViewModel.setWeeklyAlarms(requireContext(), isChecked)
        }

        binding.alarm3Switch.setOnCheckedChangeListener { _, isChecked ->
            alarmViewModel.saveSwitchState(requireContext(), binding.alarm3Switch.id, isChecked)
            showFeedback(isChecked)
            // 여기에 필요한 추가 로직 (예: 알람 설정)
        }

        binding.alarm4Switch.setOnCheckedChangeListener { _, isChecked ->
            alarmViewModel.handleCloudMessageAlarm(isChecked, userId)
            alarmViewModel.saveSwitchStateToFirebase(binding.alarm4Switch.id, isChecked, userId)
            showFeedback(isChecked)
        }
    }
    private fun showFeedback(isChecked: Boolean) {
        if (isChecked) {
            Toast.makeText(context, "알람이 켜졌습니다", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "알람이 꺼졌습니다", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
