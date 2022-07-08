package br.com.sda.bootstrap.sdabootstrap.api.core.port.`in`

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Requirement

interface CourseEnroller {
    fun enroll(requirement: Requirement)
}
