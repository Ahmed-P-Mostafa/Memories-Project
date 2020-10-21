package com.example.memoriesproject.database

import android.icu.text.Transliterator
import android.location.Location
import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MemoryEntity(@PrimaryKey(autoGenerate = true)
                        val id :Int?=null,val title:String?=null,
                        val description:String?=null,
                        val imagesArray:ArrayList<Uri>?=null,
                        val Position:Location?=null,
                        val locationName:String) {
}