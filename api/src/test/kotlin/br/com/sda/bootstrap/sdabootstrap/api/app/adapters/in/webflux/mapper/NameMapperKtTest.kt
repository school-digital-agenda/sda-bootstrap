package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.mapper

import br.com.sda.bootstrap.sdabootstrap.api.UnitTest
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Name
import io.github.serpro69.kfaker.faker
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NameMapperKtTest : UnitTest() {

    private val faker = faker { }

    @Test
    fun `Should split 3 part name to first, middle and last name`() {
        val source = faker.name.nameWithMiddle()
        val result = Name.splitFromString(source)
        assertEquals(source, listOf(result.firstName, result.middleName, result.lastName).joinToString(separator = " "))
    }

    @Test
    fun `Should split 4 part name to first, middle and last name`() {
        val source = listOf(faker.name.nameWithMiddle(), faker.name.lastName()).joinToString(separator = " ")
        val result = Name.splitFromString(source)
        assertEquals(source, listOf(result.firstName, result.middleName, result.lastName).joinToString(separator = " "))
    }

    @Test
    fun `Should split 2 part name to first and last name`() {
        val source = listOf(faker.name.firstName(), faker.name.lastName()).joinToString(separator = " ")
        val result = Name.splitFromString(source)
        assertEquals(source, listOf(result.firstName, result.lastName).joinToString(separator = " "))
        assertTrue(result.middleName.isNullOrBlank())
    }

    @Test
    fun `Should split 1 part name to first name only`() {
        val source = faker.name.firstName()
        val result = Name.splitFromString(source)
        assertEquals(source, result.firstName)
        assertTrue(result.middleName.isNullOrBlank())
        assertTrue(result.lastName.isNullOrBlank())
    }
}
