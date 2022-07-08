package br.com.sda.bootstrap.sdabootstrap.api.core.domain

import java.time.LocalDate

data class Requirement(
    val name: Name,
    val gender: Gender,
    val birthDate: LocalDate,
    val document: String,
    val course: String
) {
    companion object {}
}
