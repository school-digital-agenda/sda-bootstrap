package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.out.persistence.repository

import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.out.persistence.entity.CourseEntity
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.util.UUID

@Repository
interface CourseRepository: R2dbcRepository<CourseEntity, UUID> {
    fun findAllInStages(stages: List<Stage>): Flux<CourseEntity>
}
