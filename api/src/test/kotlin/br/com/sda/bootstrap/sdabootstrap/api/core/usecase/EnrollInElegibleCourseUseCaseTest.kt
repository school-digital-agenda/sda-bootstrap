package br.com.sda.bootstrap.sdabootstrap.api.core.usecase

import br.com.sda.bootstrap.sdabootstrap.api.UnitTest
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.EnrollmentAggregation
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Requirement
import br.com.sda.bootstrap.sdabootstrap.api.core.exception.EnrollmentNotElegibleException
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.CourseFetcher
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.EnrollmentAnalyzer
import br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain.buildMock
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.justRun
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
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
                course = course.id,
                birthDate = LocalDate.now().minusYears(course.stage.age.first.toLong())
            )
        val aggregate = EnrollmentAggregation(requirement, course)

        every { courseFetcher.fetchCourseById(course.id) }
            .returns(course)

        justRun { enrollmentAnalyser.sendRequirementForAnalysis(aggregate) }

        enrollInElegibleCourseUseCase.enroll(requirement)

        verify { enrollmentAnalyser.sendRequirementForAnalysis(aggregate) }
    }

    @Test
    fun `Should throws EnrollmentNotElegibleException when requirement not elegible`() {
        val course = Course.buildMock()
        val requirement = Requirement.buildMock()
            .copy(
                course = course.id,
                birthDate = LocalDate.now()
            )

        every { courseFetcher.fetchCourseById(course.id) }
            .returns(course)

        assertThrows<EnrollmentNotElegibleException> {
            enrollInElegibleCourseUseCase.enroll(requirement)
        }

        verify (exactly = 0) { enrollmentAnalyser.sendRequirementForAnalysis(any()) }
    }

}
