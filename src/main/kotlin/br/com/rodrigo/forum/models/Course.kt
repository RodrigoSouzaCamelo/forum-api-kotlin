package br.com.rodrigo.forum.models

import jakarta.persistence.*

@Entity
data class Course(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    val name: String? = null,

    @Column(name = "category", nullable = false)
    val category: String? = null
)
