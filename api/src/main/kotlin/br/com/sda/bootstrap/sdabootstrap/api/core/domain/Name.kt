package br.com.sda.bootstrap.sdabootstrap.api.core.domain

data class Name(
    val firstName: String,
    val middleName: String? = null,
    val lastName: String
) {
    companion object {}
}
