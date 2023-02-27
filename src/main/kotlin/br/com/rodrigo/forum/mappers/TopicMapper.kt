package br.com.rodrigo.forum.mappers

import br.com.rodrigo.forum.dtos.TopicOutputDto
import br.com.rodrigo.forum.models.Topic
import org.springframework.stereotype.Component

@Component
class TopicMapper {
    fun toOutput(topic: Topic): TopicOutputDto {
        return TopicOutputDto(
                id = topic.id ?: 0L,
                title = topic.title,
                message = topic.message,
                status = topic.status,
                createdAt = topic.createdAt
        )
    }

    fun toOutput(topics: List<Topic>): List<TopicOutputDto> {
        return topics.map(::toOutput)
    }
}