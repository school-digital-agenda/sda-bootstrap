package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.out.persistence

import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.out.persistence.mapper.toCourse
import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.out.persistence.repository.CourseRepository
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.CourseFetcher
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.CoursesFinder
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

@Component
class CoursePersistenceAdapter(
    private val courseRepository: CourseRepository
): CoursesFinder, CourseFetcher {
    override fun findCoursesByStage(stages: List<Stage>): Flux<Course> =
        courseRepository.findAllInStages(stages)
            .map { it.toCourse() }

    override fun fetchCourseById(id: UUID): Mono<Course> =
        courseRepository.findById(id)
            .map { it.toCourse() }
}
