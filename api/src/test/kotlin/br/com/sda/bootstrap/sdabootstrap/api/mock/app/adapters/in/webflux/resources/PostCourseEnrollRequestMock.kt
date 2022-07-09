import br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.resources.PostCourseEnrollRequest
import br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain.fixtureBirthDate
import br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain.fixtureCpf
import br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain.fixtureGender
import br.com.sda.bootstrap.sdabootstrap.api.mock.core.domain.fixtureUuid
import io.github.serpro69.kfaker.faker

private val faker = faker {  }

fun PostCourseEnrollRequest.Companion.buildMock(): PostCourseEnrollRequest =
    PostCourseEnrollRequest(
        name = faker.rickAndMorty.characters(),
        gender = fixtureGender().name,
        birthDate = fixtureBirthDate(2),
        document = fixtureCpf(),
        course = fixtureUuid()
    )
