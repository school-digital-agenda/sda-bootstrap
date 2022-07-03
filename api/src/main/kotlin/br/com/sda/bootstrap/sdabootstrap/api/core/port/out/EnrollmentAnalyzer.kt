package br.com.sda.bootstrap.sdabootstrap.api.core.port.out

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Requirement

interface EnrollmentAnalyzer {
    fun sendRequirementForAnalysis(requirement: Requirement)
}
