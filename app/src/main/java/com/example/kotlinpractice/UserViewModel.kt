package com.example.kotlinpractice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room

class UserViewModel(application: Application) : AndroidViewModel(application) {
    var userDB : UserDatabase = Room.databaseBuilder(
        application,
        UserDatabase::class.java,
        "user-profile"
    ).allowMainThreadQueries().build()
    var userProfileList = userDB.userDao().getAll()

    fun insert(user: User){
        userDB.userDao().insert(user)
    }
}