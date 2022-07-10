package br.com.sda.bootstrap.sdabootstrap.api.core.port.`in`

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Requirement
import reactor.core.publisher.Mono
import java.util.UUID

interface CourseEnroller {
    fun enroll(requirement: Requirement): Mono<UUID>
}
