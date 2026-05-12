package com.example.ideavault.data.repository

import com.example.ideavault.domain.model.Idea
import kotlinx.coroutines.flow.Flow

interface IdeaRepository {
    fun getAllIdeasByDate(): Flow<List<Idea>>
    fun getAllIdeasByImportance(): Flow<List<Idea>>
    suspend fun saveIdea(idea: Idea)
    suspend fun deleteIdea(idea: Idea)
}
