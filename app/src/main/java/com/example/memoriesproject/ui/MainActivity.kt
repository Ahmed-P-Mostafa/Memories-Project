package com.example.memoriesproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memoriesproject.MemoryAdapter
import com.example.memoriesproject.R
import com.example.memoriesproject.database.MemoryDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = MemoryDatabase.getInstance(this).memoryDao().getAllMemories()

        val adapter = MemoryAdapter(this,list)
        addMemory_fab.setOnClickListener({
            val intent = Intent(this,MemoryDialog::class.java)
            startActivity(intent)
        })
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter


    }
}