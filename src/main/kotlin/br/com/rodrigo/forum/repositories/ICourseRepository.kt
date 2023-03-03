package br.com.rodrigo.forum.repositories

import br.com.rodrigo.forum.models.Course
import org.springframework.data.jpa.repository.JpaRepository

interface ICourseRepository : JpaRepository<Course, Long> {
}