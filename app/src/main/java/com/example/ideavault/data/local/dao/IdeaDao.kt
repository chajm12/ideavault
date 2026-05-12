package com.example.ideavault.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ideavault.data.local.entity.IdeaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IdeaDao {

    @Query("SELECT * FROM ideas ORDER BY createdAt DESC")
    fun getAllIdeasByDate(): Flow<List<IdeaEntity>>

    @Query("SELECT * FROM ideas ORDER BY importance DESC")
    fun getAllIdeasByImportance(): Flow<List<IdeaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIdea(idea: IdeaEntity)

    @Delete
    suspend fun deleteIdea(idea: IdeaEntity)
}
