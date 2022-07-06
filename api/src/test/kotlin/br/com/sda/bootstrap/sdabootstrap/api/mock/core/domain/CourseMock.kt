package br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import io.github.serpro69.kfaker.faker
import reactor.core.publisher.Flux
import reactor.core.publisher.SynchronousSink
import java.math.BigDecimal

private val faker = faker {  }

fun Course.Companion.buildCourseMock(): Course =
    Course(
        id = fixtureUuid(),
        name = faker.rickAndMorty.locations(),
        description = faker.rickAndMorty.quotes(),
        stage = fixtureStage(),
        tuitionFee = BigDecimal(fixtureMoney())
    )

fun Course.Companion.generateCourse(): Flux<Course> =
    Flux.generate { synchronousSink: SynchronousSink<Course> ->
        synchronousSink.next(
            Course.buildCourseMock()
        )
    }
