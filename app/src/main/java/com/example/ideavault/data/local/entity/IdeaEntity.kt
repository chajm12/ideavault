package com.example.ideavault.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ideavault.domain.model.Idea

@Entity(tableName = "ideas")
data class IdeaEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val importance: Int,
    val createdAt: Long
)

fun IdeaEntity.toDomain(): Idea = Idea(
    id = id,
    title = title,
    description = description,
    importance = importance,
    createdAt = createdAt
)

fun Idea.toEntity(): IdeaEntity = IdeaEntity(
    id = id,
    title = title,
    description = description,
    importance = importance,
    createdAt = createdAt
)
