package br.com.rodrigo.forum.models

import jakarta.persistence.*

@Entity(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    val name: String? = null,

    @Column(name = "email", nullable = false)
    val email: String? = null
)
