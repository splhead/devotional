package com.splhead.devotional.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "devotional", primaryKeys = ["date","type"])
data class Devotional(@ColumnInfo(name = "title") val title: String,
                      @ColumnInfo(name = "verse") val verse: String,
                      @ColumnInfo(name = "date") val date: Date,
                      @ColumnInfo(name = "text") val text: String,
                      @ColumnInfo(name = "type") val type: Int,
                      @ColumnInfo(name = "favorite") var favorite: Boolean = false) {
//    @ColumnInfo(name = "id")
//    @PrimaryKey(autoGenerate = true)
//    var id: Long = 0
}