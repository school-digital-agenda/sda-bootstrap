package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux

import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.mapper.toCourseResourceResponse
import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.mapper.toRequirement
import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.resources.GetCourseResourceResponse
import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.resources.PostCourseEnrollRequest
import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.springdoc.CoursesResourceSpringdoc
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import br.com.sda.bootstrap.sdabootstrap.api.core.port.`in`.CourseEnroller
import br.com.sda.bootstrap.sdabootstrap.api.core.port.`in`.CoursesByStageFinder
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/courses")
class CoursesResource(
    private val courseEnroller: CourseEnroller,
    private val coursesByStageFinder: CoursesByStageFinder
): CoursesResourceSpringdoc {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    override fun getCoursesByStages(
        @RequestParam stages: List<Stage>
    ): Flux<GetCourseResourceResponse> =
        coursesByStageFinder.fetchCoursesByStage(stages)
            .map { it.toCourseResourceResponse() }

    @PostMapping("/enroll")
    @ResponseStatus(HttpStatus.CREATED)
    override fun enroll(request: PostCourseEnrollRequest) =
            courseEnroller.enroll(request.toRequirement())

}
