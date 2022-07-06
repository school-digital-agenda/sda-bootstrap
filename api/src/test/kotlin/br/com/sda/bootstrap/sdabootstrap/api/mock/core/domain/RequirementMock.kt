package br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Name
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Requirement
import com.appmattus.kotlinfixture.kotlinFixture
import io.github.serpro69.kfaker.faker
import java.time.LocalDate
import kotlin.random.Random

private val faker = faker {  }

private val fixture = kotlinFixture()

fun Requirement.Companion.buildMock(): Requirement =
    Requirement(
        name = Name.buildMock(),
        gender = fixtureGender(),
        birthDate = LocalDate.now().minusYears(Random.nextLong(2, 19)),
        document = fixtureCpf(),
        course = faker.programmingLanguage.name()
    )
