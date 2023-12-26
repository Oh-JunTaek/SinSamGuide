package com.eunma.sinsamguide.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.eunma.sinsamguide.databinding.DialogEventBinding
import com.eunma.sinsamguide.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val eventButton: Button = binding.buttonEvent
        eventButton.setOnClickListener {
            showEventDialog()
        }

        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    private fun showEventDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("이벤트 선택")

        val dialogBinding: DialogEventBinding = DialogEventBinding.inflate(layoutInflater)
        val buttonMain: Button = dialogBinding.buttonMain
        val buttonSeason: Button = dialogBinding.buttonSeason
        val buttonSpecial: Button = dialogBinding.buttonSpecial
        buttonMain.setOnClickListener {
            // 메인 버튼 클릭시 할 일
        }
        buttonSeason.setOnClickListener {
            // 시즌 버튼 클릭시 할 일
        }
        buttonSpecial.setOnClickListener {
            // 특별 버튼 클릭시 할 일
        }

        builder.setView(dialogBinding.root)
        builder.setNegativeButton("취소") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}