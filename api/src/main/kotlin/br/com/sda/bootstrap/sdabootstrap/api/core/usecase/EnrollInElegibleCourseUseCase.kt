package br.com.sda.bootstrap.sdabootstrap.api.core.usecase

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.EnrollmentAggregation
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Requirement
import br.com.sda.bootstrap.sdabootstrap.api.core.exception.EnrollmentNotElegibleException
import br.com.sda.bootstrap.sdabootstrap.api.core.port.`in`.CourseEnroller
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.CourseFetcher
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.EnrollmentAnalyzer
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.LocalDate
import java.time.Period
import java.util.UUID

@Service
class EnrollInElegibleCourseUseCase(
    private val courseFetcher: CourseFetcher,
    private val enrollmentAnalyser: EnrollmentAnalyzer
) : CourseEnroller {
    override fun enroll(requirement: Requirement): Mono<UUID> =
        courseFetcher.fetchCourseById(requirement.course)
            .log()
            .flatMap { entity ->
                Mono.just(
                    EnrollmentAggregation(UUID.randomUUID(), requirement, entity)
                        .also { checkEligibility(it) }
                        .also { enrollmentAnalyser.sendRequirementForAnalysis(it) }
                        .id
                )
                    .log()
            }

    private fun checkEligibility(enrollmentAggregation: EnrollmentAggregation) {
        enrollmentAggregation.requirement.birthDate
            .let { Period.between(it, LocalDate.now()).years }
            .takeUnless { enrollmentAggregation.course.stage.age.contains(it) }
            ?.also { throw EnrollmentNotElegibleException() }
    }
}
