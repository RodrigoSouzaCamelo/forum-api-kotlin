package br.com.rodrigo.forum.dtos

data class TopicInputDto(
        val title: String,
        val message: String,
        val courseId: Long,
        val authorId: Long
)
