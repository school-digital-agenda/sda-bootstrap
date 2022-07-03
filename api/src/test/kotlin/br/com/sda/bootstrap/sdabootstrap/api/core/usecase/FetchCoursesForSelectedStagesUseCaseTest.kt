package br.com.sda.bootstrap.sdabootstrap.api.core.usecase

import br.com.sda.bootstrap.sdabootstrap.api.UnitTest
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.CoursesFinder
import br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain.buildCourseMock
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

internal class FetchCoursesForSelectedStagesUseCaseTest: UnitTest() {

    @MockK
    private lateinit var coursesFinder: CoursesFinder

    @InjectMockKs
    private lateinit var fetchCoursesForSelectedStagesUseCase: FetchCoursesForSelectedStagesUseCase

    @Test
    fun `Should return courses fetched for corresponding stages`() {
        val stages = listOf(Stage.BERCARIO)

        every { coursesFinder.findCoursesByStage(stages) }
            .returns(Flux.just(Course.buildCourseMock()))

        StepVerifier.create(fetchCoursesForSelectedStagesUseCase.fetchCoursesByStage(stages))
            .expectNextCount(1)
            .verifyComplete()
    }
}
