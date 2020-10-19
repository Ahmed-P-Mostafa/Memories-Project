package com.example.memoriesproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MemoryEntity::class), version = 1, exportSchema = false)
abstract class MemoryDatabase:RoomDatabase() {

    abstract fun memoryDao():MemoryDAO

    companion object{
        var instance:MemoryDatabase?= null


        // singleton object to return same object to all over the application
        // synchronized annotation is to serialized the operations id's to not make different operations with same object id
        @Synchronized
        fun getInstance(context: Context?): MemoryDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context!!, MemoryDatabase::class.java, "database")
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
            return instance as MemoryDatabase
        }
    }
}