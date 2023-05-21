package com.example.navapp1.ui.ideas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IdeasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "More Recommendations" +
                "Even more recommendations"
    }
    val text: LiveData<String> = _text
}