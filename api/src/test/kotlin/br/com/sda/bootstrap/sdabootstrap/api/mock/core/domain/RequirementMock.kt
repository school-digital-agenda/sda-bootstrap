package br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Name
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Requirement
import br.com.sda.bootstrap.sdabootstrap.api.mock.fixtureBirthDate
import com.appmattus.kotlinfixture.kotlinFixture
import io.github.serpro69.kfaker.faker

private val faker = faker {  }

private val fixture = kotlinFixture()

fun Requirement.Companion.buildMock(): Requirement =
    Requirement(
        name = Name.buildMock(),
        gender = br.com.sda.bootstrap.sdabootstrap.api.mock.fixtureGender(),
        birthDate = fixtureBirthDate(),
        document = br.com.sda.bootstrap.sdabootstrap.api.mock.fixtureCpf(),
        course = faker.programmingLanguage.name()
    )
