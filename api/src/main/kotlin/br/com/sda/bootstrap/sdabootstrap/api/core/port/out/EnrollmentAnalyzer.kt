package br.com.sda.bootstrap.sdabootstrap.api.core.port.out

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.EnrollmentAggregation

interface EnrollmentAnalyzer {
    fun sendRequirementForAnalysis(courseEnrollmentRequirement: EnrollmentAggregation)
}
