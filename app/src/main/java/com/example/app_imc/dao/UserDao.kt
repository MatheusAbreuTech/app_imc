package com.example.app_imc.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.app_imc.entities.User

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM users ORDER BY date ASC")
    fun getAll(): MutableList<User>

    @Update
    fun update(user: User)

    @Query("DELETE FROM users WHERE uid = :id")
    fun delete(id: Int)
}