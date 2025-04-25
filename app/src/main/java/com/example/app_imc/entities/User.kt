package com.example.app_imc.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User (
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "height") val height: Float,
    @ColumnInfo(name = "weight") val weight: Float,
    @ColumnInfo(name = "date") val date: String
)
{
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}