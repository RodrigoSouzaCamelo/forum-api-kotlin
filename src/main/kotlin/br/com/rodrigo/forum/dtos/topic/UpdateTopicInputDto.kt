package br.com.rodrigo.forum.dtos.topic

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateTopicInputDto(
    @field:NotNull(message = "id não pode ser nulo.")
    val id: Long,

    @field:NotEmpty(message = "title não pode ser em branco.")
    @field:Size(min = 5, max = 100, message = "title deve ter entre 5 e 100 caracteres.")
    val title: String,

    @field:NotEmpty(message = "message não pode ser em branco.")
    val message: String
)