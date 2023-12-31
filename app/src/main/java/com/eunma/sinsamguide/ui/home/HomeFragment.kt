package com.eunma.sinsamguide.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.eunma.sinsamguide.databinding.DialogContentsBinding
import com.eunma.sinsamguide.databinding.DialogEventBinding
import com.eunma.sinsamguide.databinding.DialogGuideBinding
import com.eunma.sinsamguide.databinding.FragmentHomeBinding
import com.eunma.sinsamguide.ui.contents.MainContentsActivity
import com.eunma.sinsamguide.ui.contents.NewContentsActivity
import com.eunma.sinsamguide.ui.contents.SeasonContentsActivity
import com.eunma.sinsamguide.ui.encyclopedia.EncyclopediaMainActivity
import com.eunma.sinsamguide.ui.event.CashEventsActivity
import com.eunma.sinsamguide.ui.event.MainEventsActivity
import com.eunma.sinsamguide.ui.event.SeasonEventsActivity
import com.eunma.sinsamguide.ui.event.SpecialEventsActivity

class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val eventButton: Button = binding.btnEvent
        eventButton.setOnClickListener {
            showEventDialog()
        }

        val guideButton: Button = binding.btnGuide
        guideButton.setOnClickListener {
            showGuideDialog()
        }

        val contentsButton: Button = binding.btnContents
        contentsButton.setOnClickListener {
            showContentsDialog()
        }

        val pictorialButton = binding.btnPictorialBook
        pictorialButton.setOnClickListener {
            val intent = Intent(context, EncyclopediaMainActivity::class.java)
            // 필요하다면, 여기에 인텐트에 추가적인 데이터를 넣을 수 있습니다.
            // 예: intent.putExtra("title", "제목")
            //     intent.putExtra("content", "내용")
            startActivity(intent)
        }

        val freeboardButton = binding.btnFreeBoad
        freeboardButton.setOnClickListener {
            Toast.makeText(context, "미구현입니다.", Toast.LENGTH_SHORT).show()
        }

        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    private fun showGuideDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("기본 가이드 및 Tip")

        val dialogBinding: DialogGuideBinding = DialogGuideBinding.inflate(layoutInflater)
        val buttonGuide: Button = dialogBinding.btnBasicGuide
        val buttonDeveloperTip: Button = dialogBinding.btnDeveloperTip
        val buttonUserTip: Button = dialogBinding.btnUserTip
        buttonGuide.setOnClickListener {

        }
        buttonDeveloperTip.setOnClickListener {

        }
        buttonUserTip.setOnClickListener {

        }
        builder.setView(dialogBinding.root)
        builder.setNegativeButton("취소") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    private fun showContentsDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("컨텐츠에 대한 설명")

        val dialogBinding: DialogContentsBinding = DialogContentsBinding.inflate(layoutInflater)
        val buttonMainContents: Button = dialogBinding.btnMainContents
        val buttonSeasonContents: Button = dialogBinding.btnSeasonContents
        val buttonNewContents: Button = dialogBinding.btnNewContents
        buttonMainContents.setOnClickListener {
            val intent = Intent(requireContext(), MainContentsActivity::class.java)
            startActivity(intent)
        }

        buttonSeasonContents.setOnClickListener {
            val intent = Intent(requireContext(), SeasonContentsActivity::class.java)
            startActivity(intent)
        }
        buttonNewContents.setOnClickListener {
            val intent = Intent(requireContext(), NewContentsActivity::class.java)
            startActivity(intent)
        }

        builder.setView(dialogBinding.root)
        builder.setNegativeButton("취소") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }

    private fun showEventDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("이벤트탭 대한 공략")

        val dialogBinding: DialogEventBinding = DialogEventBinding.inflate(layoutInflater)
        val buttonMain: Button = dialogBinding.btnMainEvent
        val buttonSeason: Button = dialogBinding.btnSeasonEvent
        val buttonSpecial: Button = dialogBinding.btnSpecialEvent
        val buttonSpend : Button = dialogBinding.btnSpendEvent
        buttonMain.setOnClickListener {
            val intent = Intent(requireContext(), MainEventsActivity::class.java)
            startActivity(intent)
        }
        buttonSeason.setOnClickListener {
            val intent = Intent(requireContext(), SeasonEventsActivity::class.java)
            startActivity(intent)
        }
        buttonSpecial.setOnClickListener {
            val intent = Intent(requireContext(), SpecialEventsActivity::class.java)
            startActivity(intent)
        }
        buttonSpend.setOnClickListener {
            val intent = Intent(requireContext(), CashEventsActivity::class.java)
            startActivity(intent)
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