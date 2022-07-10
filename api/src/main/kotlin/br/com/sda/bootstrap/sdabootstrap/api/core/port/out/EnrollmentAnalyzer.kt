package br.com.sda.bootstrap.sdabootstrap.api.core.port.out

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.EnrollmentAggregation
import reactor.core.publisher.Mono

interface EnrollmentAnalyzer {
    fun sendRequirementForAnalysis(courseEnrollmentRequirement: EnrollmentAggregation): Mono<Unit>
}
