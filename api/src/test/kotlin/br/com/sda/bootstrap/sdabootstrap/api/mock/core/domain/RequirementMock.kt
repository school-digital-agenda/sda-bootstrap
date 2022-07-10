package br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Name
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Requirement
import br.com.sda.bootstrap.sdabootstrap.api.mock.fixtureBirthDate
import br.com.sda.bootstrap.sdabootstrap.api.mock.fixtureCpf
import br.com.sda.bootstrap.sdabootstrap.api.mock.fixtureGender
import java.util.UUID

fun Requirement.Companion.buildMock(): Requirement =
    Requirement(
        name = Name.buildMock(),
        gender = fixtureGender(),
        birthDate = fixtureBirthDate(),
        document = fixtureCpf(),
        course = UUID.randomUUID()
    )
