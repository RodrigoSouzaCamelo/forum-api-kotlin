package br.com.rodrigo.forum.services

import br.com.rodrigo.forum.dtos.TopicInputDto
import br.com.rodrigo.forum.dtos.TopicOutputDto
import br.com.rodrigo.forum.models.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
        private var topics: List<Topic> = arrayListOf(),
        private val courseService: CourseService,
        private val userService: UserService
) {
    fun getAll(): List<TopicOutputDto> {
        return topics.map(::toOutput)
    }


    fun getById(id: Long): TopicOutputDto? {
        return topics
                .filter { topic -> topic.id == id }
                .map(::toOutput)
                .firstOrNull()
    }

    fun create(dto: TopicInputDto) {
        val course = courseService.getById(dto.courseId)
        val author = userService.getById(dto.authorId)

        if(author != null && course != null) {
            val newTopic = Topic(
                    id = topics.size + 1L,
                    title = dto.title,
                    message = dto.message,
                    course = course,
                    author = author
            )

            topics += newTopic
        }
    }

    private fun toOutput(topic: Topic): TopicOutputDto {
        return TopicOutputDto(
                id = topic.id ?: 0L,
                title = topic.title,
                message = topic.message,
                status = topic.status,
                createdAt = topic.createdAt
        )
    }
}