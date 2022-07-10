package br.com.sda.bootstrap.sdabootstrap.api.core.usecase

import br.com.sda.bootstrap.sdabootstrap.api.UnitTest
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Requirement
import br.com.sda.bootstrap.sdabootstrap.api.core.exception.EnrollmentNotElegibleException
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.CourseFetcher
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.EnrollmentAnalyzer
import br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain.buildMock
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono
import reactor.kotlin.test.expectError
import reactor.test.StepVerifier
import java.time.LocalDate

internal class EnrollInElegibleCourseUseCaseTest: UnitTest() {

    @MockK
    private lateinit var courseFetcher: CourseFetcher

    @MockK
    private lateinit var enrollmentAnalyser: EnrollmentAnalyzer

    @InjectMockKs
    private lateinit var enrollInElegibleCourseUseCase: EnrollInElegibleCourseUseCase

    @Test
    fun `Should send requirement for analysis when course exists and requirement is elegible`() {
        val course = Course.buildMock()
        val requirement = Requirement.buildMock()
            .copy(
                course = course.id!!,
                birthDate = LocalDate.now().minusYears(course.stage.age.first.toLong())
            )

        every { courseFetcher.fetchCourseById(course.id!!) }
            .returns(Mono.just(course))

        every { enrollmentAnalyser.sendRequirementForAnalysis(any()) }
            .returns(Mono.empty())

        StepVerifier.create(enrollInElegibleCourseUseCase.enroll(requirement))
            .expectNextCount(1)
            .then { verify { enrollmentAnalyser.sendRequirementForAnalysis(any()) } }
            .verifyComplete()
    }

    @Test
    fun `Should throws EnrollmentNotElegibleException when requirement not elegible`() {
        val course = Course.buildMock()
        val requirement = Requirement.buildMock()
            .copy(
                course = course.id!!,
                birthDate = LocalDate.now()
            )

        every { courseFetcher.fetchCourseById(course.id!!) }
            .returns(Mono.just(course))

        StepVerifier.create(enrollInElegibleCourseUseCase.enroll(requirement))
            .then { verify (exactly = 0) { enrollmentAnalyser.sendRequirementForAnalysis(any()) }}
            .expectError(EnrollmentNotElegibleException::class)
            .verify()
    }
}
