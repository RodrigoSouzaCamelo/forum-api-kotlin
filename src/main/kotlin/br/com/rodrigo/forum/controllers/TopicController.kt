package br.com.rodrigo.forum.controllers

import br.com.rodrigo.forum.dtos.topic.CreateTopicInputDto
import br.com.rodrigo.forum.dtos.topic.TopicOutputDto
import br.com.rodrigo.forum.dtos.topic.UpdateTopicInputDto
import br.com.rodrigo.forum.services.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topic")
class TopicController(private val service: TopicService) {

    @GetMapping
    @Cacheable("topics")
    fun getAll(
        @RequestParam(required = false) courseName: String?,
        pagination: Pageable
    ): Page<TopicOutputDto> {
        return service.getAll(courseName, pagination)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicOutputDto? {
        return service.getById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict("topics", allEntries = true)
    fun create(
        @RequestBody @Valid dto: CreateTopicInputDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicOutputDto> {
        val createdTopic = service.create(dto)
        val uri = uriBuilder
            .path("/topic/${createdTopic.id}")
            .build()
            .toUri()

        return ResponseEntity.created(uri).body(createdTopic)
    }

    @PutMapping
    @Transactional
    @CacheEvict("topics", allEntries = true)
    fun update(@RequestBody @Valid dto: UpdateTopicInputDto): ResponseEntity<TopicOutputDto> {
        val updatedTopic = service.update(dto)
        return ResponseEntity.ok(updatedTopic)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict("topics", allEntries = true)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}