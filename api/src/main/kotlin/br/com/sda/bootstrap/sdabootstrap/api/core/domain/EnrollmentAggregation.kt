package br.com.sda.bootstrap.sdabootstrap.api.core.domain

import java.util.UUID

data class EnrollmentAggregation(
    val id: UUID,
    val requirement: Requirement,
    val course: Course
)
