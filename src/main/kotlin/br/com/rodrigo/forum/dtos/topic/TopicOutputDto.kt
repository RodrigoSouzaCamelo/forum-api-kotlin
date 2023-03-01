package br.com.rodrigo.forum.dtos.topic

import br.com.rodrigo.forum.models.TopicStatus
import java.time.LocalDateTime

data class TopicOutputDto(
        val id: Long,
        val title: String,
        val message: String,
        val status: TopicStatus,
        val createdAt: LocalDateTime
)
