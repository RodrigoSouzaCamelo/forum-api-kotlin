package br.com.rodrigo.forum.repositories

import br.com.rodrigo.forum.models.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface ITopicRepository : JpaRepository<Topic, Long> {
    fun findByCourseName(courseName: String): List<Topic>
}