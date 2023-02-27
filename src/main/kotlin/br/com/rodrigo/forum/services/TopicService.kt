package br.com.rodrigo.forum.services

import br.com.rodrigo.forum.dtos.topic.CreateTopicInputDto
import br.com.rodrigo.forum.dtos.topic.TopicOutputDto
import br.com.rodrigo.forum.dtos.topic.UpdateTopicInputDto
import br.com.rodrigo.forum.mappers.TopicMapper
import br.com.rodrigo.forum.models.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
        private var topics: List<Topic?> = arrayListOf(),
        private val mapper: TopicMapper
) {
    fun getAll(): List<TopicOutputDto> {
        return mapper.toOutput(topics)
    }


    fun getById(id: Long): TopicOutputDto? {
        return topics
                .filter { topic -> topic?.id == id }
                .map { topic -> mapper.toOutput(topic) }
                .firstOrNull()
    }

    fun create(dto: CreateTopicInputDto): TopicOutputDto {
        var newTopic = mapper.toTopic(dto)
        newTopic?.id = topics.size + 1L
        topics += newTopic
        return mapper.toOutput(newTopic)
    }

    fun update(dto: UpdateTopicInputDto): TopicOutputDto {
        val topic = topics.first { t -> t?.id == dto.id }
        topics -= topic
        val updatedTopic = Topic(
                id = dto.id,
                title = dto.title,
                message = dto.message,
                status = topic!!.status,
                author = topic.author,
                course = topic.course,
                answers = topic.answers,
                createdAt = topic.createdAt
        )
        topics += updatedTopic

        return mapper.toOutput(updatedTopic)
    }

    fun delete(id: Long) {
        val topic = topics.filter { t -> t?.id == id }
        topics -= topic
    }
}