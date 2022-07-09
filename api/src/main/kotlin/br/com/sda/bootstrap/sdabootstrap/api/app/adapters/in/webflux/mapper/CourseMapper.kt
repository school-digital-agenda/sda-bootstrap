package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.mapper

import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.resources.GetCourseResourceResponse
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course

fun Course.toCourseResourceResponse() =
    GetCourseResourceResponse(
        id = this.id,
        name = this.name,
        description = this.description,
        stage = this.stage,
        tuitionFee = this.tuitionFee
    )
