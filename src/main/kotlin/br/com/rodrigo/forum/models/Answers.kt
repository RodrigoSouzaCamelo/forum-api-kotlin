package br.com.rodrigo.forum.models

import java.time.LocalDateTime

class Answers(
        val id: Long? = null,
        val message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val author: User,
        val topic: Topic,
        val solution: Boolean
)
