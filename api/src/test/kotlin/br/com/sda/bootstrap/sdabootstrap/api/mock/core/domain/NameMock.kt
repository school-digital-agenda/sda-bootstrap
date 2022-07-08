package br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Name
import io.github.serpro69.kfaker.faker

private val faker = faker {  }

fun Name.Companion.buildMock(): Name =
    Name(
        faker.name.firstName(),
        faker.name.nameWithMiddle(),
        faker.name.lastName()
    )
