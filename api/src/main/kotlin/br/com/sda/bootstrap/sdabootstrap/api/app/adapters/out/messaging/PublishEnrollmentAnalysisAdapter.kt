package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.out.messaging

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.EnrollmentAggregation
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.EnrollmentAnalyzer
import org.springframework.stereotype.Component

@Component
class PublishEnrollmentAnalysisAdapter: EnrollmentAnalyzer {
    override fun sendRequirementForAnalysis(courseEnrollmentRequirement: EnrollmentAggregation) {
        TODO("Not yet implemented")
    }
}
