package ru.dims7.android.terver

import org.junit.Assert.*
import org.junit.Test
import java.math.BigInteger

class UtilTest{
    @Test
    fun bigIntegerToReadable_isCorrect() {
        assertEquals("0", BigInteger("0").toReadable())
        assertEquals("100", BigInteger("100").toReadable())
        assertEquals("1'234", BigInteger("1234").toReadable())
        assertEquals("1'234'567'890", BigInteger("1234567890").toReadable())
    }
}