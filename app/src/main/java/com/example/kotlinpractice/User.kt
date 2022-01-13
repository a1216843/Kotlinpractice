package com.example.kotlinpractice

import androidx.room.Entity
import androidx.room.PrimaryKey

// DB 테이블
@Entity
class User constructor(val name : String, val age : String, val gender : Int, var phone : String){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}