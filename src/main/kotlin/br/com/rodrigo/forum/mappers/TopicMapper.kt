package br.com.rodrigo.forum.mappers

import br.com.rodrigo.forum.dtos.topic.CreateTopicInputDto
import br.com.rodrigo.forum.dtos.topic.TopicOutputDto
import br.com.rodrigo.forum.models.Topic
import br.com.rodrigo.forum.models.TopicStatus
import br.com.rodrigo.forum.services.CourseService
import br.com.rodrigo.forum.services.UserService
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TopicMapper(
        private val courseService: CourseService,
        private val userService: UserService,
) {
    fun toTopic(dto: CreateTopicInputDto): Topic? {
        val course = courseService.getById(dto.courseId)
        val author = userService.getById(dto.authorId)

        if (author == null || course == null) return null

        return Topic(
                title = dto.title,
                message = dto.message,
                course = course,
                author = author
        )
    }

    fun toTopic(topicInputs: List<CreateTopicInputDto>): List<Topic?> {
        return topicInputs.map(::toTopic)
    }

    fun toOutput(topic: Topic?): TopicOutputDto {
        return TopicOutputDto(
                id = topic?.id ?: 0L,
                title = topic?.title ?: "",
                message = topic?.message ?: "",
                status = topic?.status ?: TopicStatus.NOT_ANSWERED,
                createdAt = topic?.createdAt ?: LocalDateTime.now()
        )
    }

    fun toOutput(topics: List<Topic?>): List<TopicOutputDto> {
        return topics.map(::toOutput)
    }
}