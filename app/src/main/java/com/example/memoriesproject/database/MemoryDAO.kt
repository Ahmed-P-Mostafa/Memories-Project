package com.example.memoriesproject.database

import androidx.room.*

@Dao
interface MemoryDAO {

    @Insert
    fun insert(memoryEntity: MemoryEntity)

    @Update
    fun update(memoryEntity: MemoryEntity)

    @Delete
    fun delete(memoryEntity: MemoryEntity)

    @Query("Select * From MemoryEntity")
    fun getAllMemories():ArrayList<MemoryEntity>


}