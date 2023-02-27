package br.com.rodrigo.forum.services

import br.com.rodrigo.forum.dtos.TopicInputDto
import br.com.rodrigo.forum.dtos.TopicOutputDto
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

    fun create(dto: TopicInputDto) {
        var newTopic = mapper.toTopic(dto)
        newTopic?.id = topics.size + 1L
        topics += newTopic
    }
}