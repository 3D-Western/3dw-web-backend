package com.uwo.three_d.backendapi

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.sql.Date

enum class TrainingLevel {
    BasicAwareness, LimitedOperation, SupervisorLevel, FullyIndepndent
}

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
    val studentNumber: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val passwordHash: String,
    val accountCreated: Date,
    val graduationYear: Int,
    val trainingLevel: TrainingLevel
)