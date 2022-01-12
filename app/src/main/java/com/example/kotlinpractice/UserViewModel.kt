package com.example.kotlinpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    var liveData : MutableLiveData<User> = MutableLiveData()
}