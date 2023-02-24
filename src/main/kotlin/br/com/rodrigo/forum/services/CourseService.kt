package br.com.rodrigo.forum.services

import br.com.rodrigo.forum.models.Course
import org.springframework.stereotype.Service

@Service
class CourseService(var courses: List<Course>) {
    init {
        val course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programming"
        )

        courses = listOf(course)
    }

    fun getById(id: Long): Course? {
        return courses.find { it.id == id }
    }
}