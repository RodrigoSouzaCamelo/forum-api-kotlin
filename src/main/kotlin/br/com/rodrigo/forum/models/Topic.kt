package br.com.rodrigo.forum.models

import java.time.LocalDateTime

data class Topic(
        val id: Long? = null,
        val title: String,
        val message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val course: Course,
        val author: User,
        val status: TopicStatus,
        val answers: List<Answers> = ArrayList()
)
