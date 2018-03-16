package com.splhead.devotional

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "devotional")
data class Devotional(@ColumnInfo(name = "title") val title: String,
                      @ColumnInfo(name = "verse") val verse: String,
                      @ColumnInfo(name = "date") val date: String,
                      @ColumnInfo(name = "text") val text: String,
                      @ColumnInfo(name = "type") val type: Int) {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}