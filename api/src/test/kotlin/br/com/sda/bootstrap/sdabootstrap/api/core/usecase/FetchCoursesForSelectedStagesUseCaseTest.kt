package br.com.sda.bootstrap.sdabootstrap.api.core.usecase

import br.com.sda.bootstrap.sdabootstrap.api.UnitTest
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.CoursesFinder
import br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain.buildMock
import br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain.generateCourse
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import kotlin.random.Random

internal class FetchCoursesForSelectedStagesUseCaseTest : UnitTest() {

    @MockK
    private lateinit var coursesFinder: CoursesFinder

    @InjectMockKs
    private lateinit var fetchCoursesForSelectedStagesUseCase: FetchCoursesForSelectedStagesUseCase

    @Test
    fun `Should return only one course that matches for corresponding stage`() {
        val stages = listOf(Stage.BERCARIO)
        val expected = Course.buildMock()

        every { coursesFinder.findCoursesByStage(stages) }
            .returns(Flux.just(expected))

        StepVerifier.create(fetchCoursesForSelectedStagesUseCase.fetchCoursesByStage(stages))
            .expectNext(expected)
            .verifyComplete()
    }

    @Test
    fun `Should return courses fetched for corresponding stages`() {
        val stages = listOf(Stage.BERCARIO)
        val expectedQuantity = Random.nextLong(until = 100)

        every { coursesFinder.findCoursesByStage(stages) }
            .returns(Course.generateCourse().take(expectedQuantity))

        StepVerifier.create(fetchCoursesForSelectedStagesUseCase.fetchCoursesByStage(stages))
            .expectNextCount(expectedQuantity)
            .verifyComplete()
    }
}
