package com.example.ideavolt.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ideavolt.data.local.dao.IdeaDao
import com.example.ideavolt.data.local.entity.IdeaEntity

@Database(entities = [IdeaEntity::class], version = 1)
abstract class IdeaDatabase : RoomDatabase() {

    abstract fun ideaDao(): IdeaDao

    companion object {
        @Volatile
        private var INSTANCE: IdeaDatabase? = null

        fun getDatabase(context: Context): IdeaDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    IdeaDatabase::class.java,
                    "idea_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
