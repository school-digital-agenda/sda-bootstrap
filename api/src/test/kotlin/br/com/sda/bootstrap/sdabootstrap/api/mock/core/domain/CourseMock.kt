package br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import io.github.serpro69.kfaker.faker
import reactor.core.publisher.Flux
import reactor.core.publisher.SynchronousSink
import java.math.BigDecimal

private val faker = faker {  }

fun Course.Companion.buildMock(): Course =
    Course(
        id = br.com.sda.bootstrap.sdabootstrap.api.mock.fixtureUuid(),
        name = faker.rickAndMorty.locations(),
        description = faker.rickAndMorty.quotes(),
        stage = br.com.sda.bootstrap.sdabootstrap.api.mock.fixtureStage(),
        tuitionFee = BigDecimal(br.com.sda.bootstrap.sdabootstrap.api.mock.fixtureMoney())
    )

fun Course.Companion.generateCourse(): Flux<Course> =
    Flux.generate { synchronousSink: SynchronousSink<Course> ->
        synchronousSink.next(
            Course.buildMock()
        )
    }
