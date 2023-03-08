package br.com.rodrigo.forum.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String? = null,

    @Column(name = "message", nullable = false)
    var message: String? = null,

    @Column(name = "createdAt", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,

    @ManyToOne
    val course: Course = Course(),

    @ManyToOne
    val author: User = User(),

    @OneToMany(mappedBy = "topic")
    var answers: MutableList<Answer> = mutableListOf()
)
