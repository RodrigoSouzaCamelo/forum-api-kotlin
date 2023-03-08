package br.com.rodrigo.forum.services

import br.com.rodrigo.forum.dtos.topic.CreateTopicInputDto
import br.com.rodrigo.forum.dtos.topic.TopicOutputDto
import br.com.rodrigo.forum.dtos.topic.UpdateTopicInputDto
import br.com.rodrigo.forum.mappers.TopicMapper
import br.com.rodrigo.forum.repositories.ITopicRepository
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val repository: ITopicRepository,
    private val mapper: TopicMapper
) {
    fun getAll(courseName: String?): List<TopicOutputDto> {
        val topics = if(courseName != null) {
            repository.findByCourseName(courseName)
        } else {
            repository.findAll()
        }

        return mapper.toOutput(topics)
    }

    fun getById(id: Long): TopicOutputDto? {
        val topic = repository.getReferenceById(id)
        return mapper.toOutput(topic)
    }

    fun create(dto: CreateTopicInputDto): TopicOutputDto {
        var newTopic = mapper.toTopic(dto)
        newTopic?.let { repository.save(it) }
        return mapper.toOutput(newTopic)
    }

    fun update(dto: UpdateTopicInputDto): TopicOutputDto {
        val topic = repository.getReferenceById(dto.id)

        topic.id = dto.id
        topic.title = dto.title
        topic.message = dto.message

        return mapper.toOutput(topic)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}