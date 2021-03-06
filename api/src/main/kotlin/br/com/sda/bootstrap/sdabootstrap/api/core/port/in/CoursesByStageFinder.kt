package br.com.sda.bootstrap.sdabootstrap.api.core.port.`in`

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import reactor.core.publisher.Flux

interface CoursesByStageFinder {
    fun fetchCoursesByStage(stages: List<Stage>): Flux<Course>
}
