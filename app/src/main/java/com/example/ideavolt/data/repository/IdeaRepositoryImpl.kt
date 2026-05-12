package com.example.ideavolt.data.repository

import com.example.ideavolt.data.local.dao.IdeaDao
import com.example.ideavolt.data.local.entity.toDomain
import com.example.ideavolt.data.local.entity.toEntity
import com.example.ideavolt.domain.model.Idea
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class IdeaRepositoryImpl(private val dao: IdeaDao) : IdeaRepository {

    override fun getAllIdeasByDate(): Flow<List<Idea>> =
        dao.getAllIdeasByDate().map { list -> list.map { it.toDomain() } }

    override fun getAllIdeasByImportance(): Flow<List<Idea>> =
        dao.getAllIdeasByImportance().map { list -> list.map { it.toDomain() } }

    override suspend fun saveIdea(idea: Idea) = dao.insertIdea(idea.toEntity())

    override suspend fun deleteIdea(idea: Idea) = dao.deleteIdea(idea.toEntity())
}
