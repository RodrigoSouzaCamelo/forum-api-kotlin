package br.com.rodrigo.forum.services

import br.com.rodrigo.forum.models.User
import org.springframework.stereotype.Service

@Service
class UserService(var authors: List<User>) {
    init {
        val author = User(
                id = 1,
                name = "Angus Young",
                email = "angus.young@email.com"
        )

        authors = listOf(author)
    }

    fun getById(id: Long): User? {
        return authors.find { it.id == id }
    }
}