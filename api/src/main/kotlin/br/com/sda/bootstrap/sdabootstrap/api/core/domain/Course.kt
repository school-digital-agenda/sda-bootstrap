package br.com.sda.bootstrap.sdabootstrap.api.core.domain

import kotlinx.uuid.UUID
import java.math.BigDecimal

data class Course(
    val id: String,
    val name: String,
    val description: String,
    val stage: Stage,
    val tuitionFee: BigDecimal
)
