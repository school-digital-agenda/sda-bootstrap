package br.com.sda.bootstrap.sdabootstrap.api.core.domain

import java.math.BigDecimal
import java.util.UUID

data class Course(
    val id: UUID? = UUID.randomUUID(),
    val name: String,
    val description: String,
    val stage: Stage,
    val tuitionFee: BigDecimal
) {
    companion object
}
