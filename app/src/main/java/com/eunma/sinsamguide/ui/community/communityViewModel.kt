package com.eunma.sinsamguide.ui.community

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class communityViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "업데이트 예정입니다"
    }
    val text: LiveData<String> = _text
}