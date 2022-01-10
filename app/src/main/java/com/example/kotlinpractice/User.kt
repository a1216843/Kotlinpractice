package com.example.kotlinpractice

class User constructor(val name : String, val age : String, val gender : Int){
    fun genderGetString() = if(gender == 0) "남성" else "여성"
}