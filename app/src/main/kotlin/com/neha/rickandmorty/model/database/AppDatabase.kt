package com.neha.rickandmorty.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.neha.rickandmorty.model.Post
import com.neha.rickandmorty.model.PostDao

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}