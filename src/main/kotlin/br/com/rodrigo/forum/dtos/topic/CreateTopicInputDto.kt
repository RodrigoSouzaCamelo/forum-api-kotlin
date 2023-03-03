package br.com.rodrigo.forum.dtos.topic

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateTopicInputDto(
    @field:NotEmpty
    @field:Size(min = 5, max = 100, message = "title deve ter entre 5 e 100 caracteres.")
    val title: String,

    @field:NotEmpty(message = "message não pode ser em branco.")
    val message: String,

    @field:NotNull(message = "courseId não pode ser nulo.")
    val courseId: Long,

    @field:NotNull(message = "authorId não pode ser nulo.")
    val authorId: Long
)
