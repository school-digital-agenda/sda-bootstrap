package br.com.sda.bootstrap.sdabootstrap.api

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

class SdaBootstrapApplicationTests(
	val applicationContext: ApplicationContext
): IntegrationTest() {
	@Test
	fun `Should context loads when application starts`() {
		assertNotNull(applicationContext)
	}
}
