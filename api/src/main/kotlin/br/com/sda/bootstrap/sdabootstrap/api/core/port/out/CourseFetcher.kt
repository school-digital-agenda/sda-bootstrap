package br.com.sda.bootstrap.sdabootstrap.api.core.port.out

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import reactor.core.publisher.Mono
import java.util.UUID

interface CourseFetcher {
    fun fetchCourseById(id: UUID): Mono<Course>
}
