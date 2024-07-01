package com.example.attendancedummy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.Calendar

class GreetingsViewModel : ViewModel() {

    private val _greeting = MutableLiveData<String>()
    val greeting: LiveData<String> get() = _greeting

    init {
        updateGreeting()
    }

    private fun updateGreeting() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val greetingMessage = when (hour) {
            in 0..11 -> "Good Morning"
            in 12..17 -> "Good Afternoon"
            else -> "Good Evening"
        }
        _greeting.value = greetingMessage
    }
}
