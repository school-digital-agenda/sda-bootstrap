package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.resources

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import java.math.BigDecimal

data class GetCourseResourceResponse (
    val id: String,
    val name: String,
    val description: String,
    val stage: Stage,
    val tuitionFee: BigDecimal
)
