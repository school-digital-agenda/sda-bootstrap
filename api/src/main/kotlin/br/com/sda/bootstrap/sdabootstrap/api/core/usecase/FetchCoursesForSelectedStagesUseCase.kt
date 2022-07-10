package br.com.sda.bootstrap.sdabootstrap.api.core.usecase

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Course
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import br.com.sda.bootstrap.sdabootstrap.api.core.port.`in`.CoursesByStageFinder
import br.com.sda.bootstrap.sdabootstrap.api.core.port.out.CoursesFinder
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.SignalType
import java.util.logging.Level

@Service
class FetchCoursesForSelectedStagesUseCase(
    private val coursesFinder: CoursesFinder
) : CoursesByStageFinder {
    companion object {
        private const val LOGGER_CATEGORY_FETCH_COURSES_BY_STAGE = "FetchCoursesForSelectedStages.fetchCoursesByStage"
    }

    override fun fetchCoursesByStage(stages: List<Stage>): Flux<Course> =
        coursesFinder.findCoursesByStage(stages)
            .log(LOGGER_CATEGORY_FETCH_COURSES_BY_STAGE, Level.FINE, SignalType.ON_NEXT)
            .log(LOGGER_CATEGORY_FETCH_COURSES_BY_STAGE, Level.INFO, SignalType.ON_COMPLETE)
            .log(LOGGER_CATEGORY_FETCH_COURSES_BY_STAGE, Level.SEVERE, SignalType.ON_ERROR)
}
