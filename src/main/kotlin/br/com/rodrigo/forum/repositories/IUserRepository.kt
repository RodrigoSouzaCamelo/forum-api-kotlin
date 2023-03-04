package br.com.rodrigo.forum.repositories

import br.com.rodrigo.forum.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface IUserRepository : JpaRepository<User, Long> {
}