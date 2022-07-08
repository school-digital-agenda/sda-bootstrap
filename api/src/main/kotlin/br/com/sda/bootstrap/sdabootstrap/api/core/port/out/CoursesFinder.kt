package br.com.sda.bootstrap.sdabootstrap.api.core.port.out

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import reactor.core.publisher.Flux

interface CoursesFinder {
    fun findCoursesByStage(stages: List<Stage>): Flux<Course>
}
