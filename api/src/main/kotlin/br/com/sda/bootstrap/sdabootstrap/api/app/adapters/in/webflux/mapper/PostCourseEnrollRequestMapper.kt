package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.mapper

import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.resources.PostCourseEnrollRequest
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Name
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Requirement

fun PostCourseEnrollRequest.toRequirement() =
    Requirement(
        name = Name.splitFromString(this.name),
        gender = genderFromString(this.gender),
        birthDate = this.birthDate,
        document = this.document,
        course = this.course
    )
