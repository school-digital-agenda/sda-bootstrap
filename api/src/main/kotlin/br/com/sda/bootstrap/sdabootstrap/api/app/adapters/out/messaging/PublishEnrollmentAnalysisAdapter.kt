package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.out.messaging

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.EnrollmentAggregation
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.EnrollmentAnalyzer
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class PublishEnrollmentAnalysisAdapter : EnrollmentAnalyzer {
    override fun sendRequirementForAnalysis(courseEnrollmentRequirement: EnrollmentAggregation): Mono<Unit> {
        TODO("Not yet implemented")
    }
}
