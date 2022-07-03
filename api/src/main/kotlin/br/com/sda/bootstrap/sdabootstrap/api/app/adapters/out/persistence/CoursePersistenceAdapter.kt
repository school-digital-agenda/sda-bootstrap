package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.out.persistence

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.CoursesFinder
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class CoursePersistenceAdapter: CoursesFinder {
    override fun findCoursesByStage(stages: List<Stage>): Flux<Course> {
        TODO("Not yet implemented")
    }
}
