package com.example.ideavolt.domain.model

data class Idea(
    val id: Int = 0,
    val title: String,
    val description: String,
    val importance: Int,
    val createdAt: Long = System.currentTimeMillis()
)
