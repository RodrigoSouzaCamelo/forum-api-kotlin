package br.com.rodrigo.forum.controllers

import br.com.rodrigo.forum.dtos.topic.CreateTopicInputDto
import br.com.rodrigo.forum.dtos.topic.TopicOutputDto
import br.com.rodrigo.forum.dtos.topic.UpdateTopicInputDto
import br.com.rodrigo.forum.services.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topic")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun getAll(): List<TopicOutputDto> {
        return service.getAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicOutputDto? {
        return service.getById(id)
    }

    @PostMapping
    fun create(@RequestBody @Valid dto: CreateTopicInputDto) {
        service.create(dto)
    }

    @PutMapping
    fun update(@RequestBody @Valid dto: UpdateTopicInputDto) {
        service.update(dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}