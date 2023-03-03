package br.com.rodrigo.forum.services

import br.com.rodrigo.forum.models.User
import br.com.rodrigo.forum.repositories.IUserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: IUserRepository) {
    fun getById(id: Long): User? {
        return repository.getReferenceById(id)
    }
}