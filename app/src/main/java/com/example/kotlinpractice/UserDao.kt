package com.example.kotlinpractice

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun insert(user : User)
    @Update
    fun update(user : User)
    @Delete
    fun Delete(user : User)
    @Query("SELECT * FROM User")
    fun getAll() : List<User>
}