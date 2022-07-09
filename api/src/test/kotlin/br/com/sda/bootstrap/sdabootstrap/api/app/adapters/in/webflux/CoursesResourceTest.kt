package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux

import br.com.sda.bootstrap.sdabootstrap.api.IntegrationTest
import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.resources.PostCourseEnrollRequest
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Stage
import buildMock
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CoursesResourceTest(): IntegrationTest() {
    companion object {
        private const val COURSES_URI = "/courses/"
        private const val COURSES_ENROLL_URI = "/courses/enroll"
    }

    @Nested
    inner class GetCoursesByStagesTests {
        @Test
        fun getCoursesByStages() {
            webTestClient.get()
                .uri { uriBuilder -> uriBuilder
                    .path(COURSES_URI)
                    .queryParam("stages", Stage.BERCARIO.name)
                    .build()
                }
                .exchange()
                .expectStatus().is5xxServerError
        }
    }

    @Nested
    inner class EnrollTests {
        @Test
        fun enroll() {
            val body = PostCourseEnrollRequest.buildMock()

            webTestClient.post()
                .uri { uriBuilder -> uriBuilder
                    .path(COURSES_ENROLL_URI)
                    .build()
                }
                .bodyValue(body)
                .exchange()
                .expectStatus().is5xxServerError
        }
    }
}
