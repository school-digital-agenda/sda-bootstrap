package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.mapper

import br.com.sda.bootstrap.sdabootstrap.api.UnitTest
import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Gender
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class GenderMapperKtTest: UnitTest() {

    @ParameterizedTest
    @CsvSource(*["MALE,MALE","FEMALE,FEMALE","FEME,OTHER",",UNINFORMED"])
    fun `Should convert from string to valid Gender`(
        source: String?,
        expected: Gender
    ) {
        val result = genderFromString(source)
        assertEquals(expected, result)
    }
}
