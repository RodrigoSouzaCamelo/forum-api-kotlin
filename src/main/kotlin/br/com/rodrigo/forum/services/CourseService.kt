package br.com.rodrigo.forum.services

import br.com.rodrigo.forum.models.Course
import br.com.rodrigo.forum.repositories.ICourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val repository: ICourseRepository) {
    fun getById(id: Long): Course? {
        return repository.getReferenceById(id)
    }
}