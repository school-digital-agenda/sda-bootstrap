package br.com.sda.bootstrap.sdabootstrap.api.core.port.out

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course

interface CourseFetcher {
    fun fetchCourseById(id: String): Course
}
