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

    fun create(dto: CreateTopicInputDto) {
        var newTopic = mapper.toTopic(dto)
        newTopic?.id = topics.size + 1L
        topics += newTopic
    }

    fun update(dto: UpdateTopicInputDto) {
        val topic = topics.filter { t -> t?.id == dto.id }
        topics = topics.map { t ->
            if (t?.id != dto.id) return@map t

            return@map Topic(
                    id = dto.id,
                    title = dto.title,
                    message = dto.message,
                    status = t.status,
                    author = t.author,
                    course = t.course,
                    answers = t.answers,
                    createdAt = t.createdAt
            )
        }
    }

    fun delete(id: Long) {
        val topic = topics.filter { t -> t?.id == id }
        topics -= topic
    }
}