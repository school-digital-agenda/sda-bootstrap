package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.out.persistence.mapper

import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.out.persistence.entity.CourseEntity
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course

fun CourseEntity.toCourse(): Course =
    Course(
        id = this.id,
        name = this.name,
        description = this.description,
        stage = this.stage,
        tuitionFee = this.tuitionFee
    )
