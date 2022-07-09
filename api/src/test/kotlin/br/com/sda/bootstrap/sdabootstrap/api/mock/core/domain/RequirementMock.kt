package br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Name
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Requirement
import br.com.sda.bootstrap.sdabootstrap.api.mock.fixtureBirthDate
import br.com.sda.bootstrap.sdabootstrap.api.mock.fixtureGender
import br.com.sda.bootstrap.sdabootstrap.api.mock.fixtureCpf
import com.appmattus.kotlinfixture.kotlinFixture
import io.github.serpro69.kfaker.faker

private val faker = faker {  }

private val fixture = kotlinFixture()

fun Requirement.Companion.buildMock(): Requirement =
    Requirement(
        name = Name.buildMock(),
        gender = fixtureGender(),
        birthDate = fixtureBirthDate(),
        document = fixtureCpf(),
        course = faker.programmingLanguage.name()
    )
