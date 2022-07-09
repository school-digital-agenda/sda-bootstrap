package br.com.sda.bootstrap.sdabootstrap.api

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

class SdaBootstrapApplicationTests(): IntegrationTest() {
	@Autowired
	private lateinit var applicationContext: ApplicationContext

	@Test
	fun `Should context loads when application starts`() {
		assertNotNull(applicationContext)
	}
}
