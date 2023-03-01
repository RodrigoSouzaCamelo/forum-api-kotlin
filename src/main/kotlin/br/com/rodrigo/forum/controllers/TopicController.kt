package br.com.rodrigo.forum.controllers

import br.com.rodrigo.forum.dtos.topic.CreateTopicInputDto
import br.com.rodrigo.forum.dtos.topic.TopicOutputDto
import br.com.rodrigo.forum.dtos.topic.UpdateTopicInputDto
import br.com.rodrigo.forum.services.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

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
    fun create(@RequestBody @Valid dto: CreateTopicInputDto,
               uriBuilder: UriComponentsBuilder): ResponseEntity<TopicOutputDto> {
        val createdTopic = service.create(dto)
        val uri = uriBuilder
                .path("/topic/${createdTopic.id}")
                .build()
                .toUri()

        return ResponseEntity.created(uri).body(createdTopic)
    }

    @PutMapping
    fun update(@RequestBody @Valid dto: UpdateTopicInputDto): ResponseEntity<TopicOutputDto> {
        val updatedTopic = service.update(dto)
        return ResponseEntity.ok(updatedTopic)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}