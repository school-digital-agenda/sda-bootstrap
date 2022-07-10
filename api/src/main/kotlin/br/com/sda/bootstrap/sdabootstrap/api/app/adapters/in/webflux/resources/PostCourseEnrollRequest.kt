package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.resources

import java.time.LocalDate

data class PostCourseEnrollRequest(
    val name: String,
    val gender: String,
    val birthDate: LocalDate,
    val document: String,
    val course: String
) {
    companion object
}
