package br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import com.appmattus.kotlinfixture.config.regexToRandom
import com.appmattus.kotlinfixture.kotlinFixture
import io.github.serpro69.kfaker.faker
import reactor.core.publisher.Flux
import reactor.core.publisher.SynchronousSink
import java.math.BigDecimal

private val faker = faker {  }

private val fixture = kotlinFixture()

private val uuidRegex = "[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}".toRegex()

private val moneyRegex = "[0-10-3][0-9]{3}\\.[0-9]{2}".toRegex()

fun Course.Companion.buildCourseMock(): Course =
    Course(
        fixture<String> {
            factory<String> { regexToRandom(uuidRegex) }
        },
        faker.rickAndMorty.locations(),
        faker.rickAndMorty.quotes(),
        fixture.asSequence<Stage>().iterator().next(),
        BigDecimal(fixture<String> {
            factory<String> { regexToRandom(moneyRegex) }
        })
    )

fun Course.Companion.generateCourse(): Flux<Course> =
    Flux.generate { synchronousSink: SynchronousSink<Course> ->
        synchronousSink.next(
            Course.buildCourseMock()
        )
    }
