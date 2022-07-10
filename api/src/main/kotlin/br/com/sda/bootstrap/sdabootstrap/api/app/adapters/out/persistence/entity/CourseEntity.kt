package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.out.persistence.entity

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.util.UUID

@Table(value = "course")
data class CourseEntity(
    @Id
    val id: UUID?,

    val name: String,

    val description: String,

    val stage: Stage,

    val tuitionFee: BigDecimal
)
