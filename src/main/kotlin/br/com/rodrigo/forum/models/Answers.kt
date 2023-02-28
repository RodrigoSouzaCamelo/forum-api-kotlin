package br.com.rodrigo.forum.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Answers(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(name = "message", nullable = false)
        val message: String? = null,

        @Column(name = "createdAt", nullable = false)
        val createdAt: LocalDateTime = LocalDateTime.now(),

        @Column(name = "solution", nullable = false)
        val solution: Boolean? = false,

        @ManyToOne
        val author: User = User(),

        @ManyToOne
        val topic: Topic = Topic(),
)
