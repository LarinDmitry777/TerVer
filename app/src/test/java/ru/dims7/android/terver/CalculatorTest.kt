package ru.dims7.android.terver

import org.junit.Test

import org.junit.Assert.*
import java.math.BigInteger

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CalculatorTest {

    @Test
    fun factorial_isCorrect() {
        assertEquals(BigInteger("1"), fact(1))
        assertEquals(BigInteger("2"), fact(2))
        assertEquals(BigInteger("120"), fact(5))
    }

    @Test
    fun nWithoutRepeats_isCorrect() {
        assertEquals(BigInteger("1"), pWithoutRepeats(1))
        assertEquals(BigInteger("2"), pWithoutRepeats(2))
        assertEquals(BigInteger("120"), pWithoutRepeats(5))
    }

    @Test
    fun aWithoutRepeats_isCorrect() {

        assertEquals(BigInteger("1"), aWithoutRepeats(1, 0))
        assertEquals(BigInteger("1"), aWithoutRepeats(1, 1))

        assertEquals(BigInteger("1"), aWithoutRepeats(3, 0))
        assertEquals(BigInteger("3"), aWithoutRepeats(3, 1))
        assertEquals(BigInteger("6"), aWithoutRepeats(3, 2))
        assertEquals(BigInteger("6"), aWithoutRepeats(3, 3))

        assertEquals(BigInteger("1"), aWithoutRepeats(5, 0))
        assertEquals(BigInteger("5"), aWithoutRepeats(5, 1))
        assertEquals(BigInteger("20"), aWithoutRepeats(5, 2))
        assertEquals(BigInteger("60"), aWithoutRepeats(5, 3))
        assertEquals(BigInteger("120"), aWithoutRepeats(5, 4))
        assertEquals(BigInteger("120"), aWithoutRepeats(5, 5))
    }

    @Test
    fun aWithRepeats_isCorrect() {
        assertEquals(BigInteger("1"), aWithRepeats(1, 0))
        assertEquals(BigInteger("1"), aWithRepeats(1, 1))

        assertEquals(BigInteger("1"), aWithRepeats(3, 0))
        assertEquals(BigInteger("3"), aWithRepeats(3, 1))
        assertEquals(BigInteger("9"), aWithRepeats(3, 2))
        assertEquals(BigInteger("27"), aWithRepeats(3, 3))

        assertEquals(BigInteger("1"), aWithRepeats(5, 0))
        assertEquals(BigInteger("5"), aWithRepeats(5, 1))
        assertEquals(BigInteger("25"), aWithRepeats(5, 2))
        assertEquals(BigInteger("125"), aWithRepeats(5, 3))
        assertEquals(BigInteger("625"), aWithRepeats(5, 4))
        assertEquals(BigInteger("3125"), aWithRepeats(5, 5))
    }

    @Test
    fun cWithoutRepeats_isCorrect() {
        assertEquals(BigInteger("1"), cWithoutRepeats(1, 0))
        assertEquals(BigInteger("1"), cWithoutRepeats(1, 1))

        assertEquals(BigInteger("1"), cWithoutRepeats(3, 0))
        assertEquals(BigInteger("3"), cWithoutRepeats(3, 1))
        assertEquals(BigInteger("3"), cWithoutRepeats(3, 2))
        assertEquals(BigInteger("1"), cWithoutRepeats(3, 3))

        assertEquals(BigInteger("1"), cWithoutRepeats(5, 0))
        assertEquals(BigInteger("5"), cWithoutRepeats(5, 1))
        assertEquals(BigInteger("10"), cWithoutRepeats(5, 2))
        assertEquals(BigInteger("10"), cWithoutRepeats(5, 3))
        assertEquals(BigInteger("5"), cWithoutRepeats(5, 4))
        assertEquals(BigInteger("1"), cWithoutRepeats(5, 5))
    }

    @Test
    fun cWithRepeatsCorrect_isCorrect() {
        assertEquals(BigInteger("1"), cWithRepeats(1, 0))
        assertEquals(BigInteger("1"), cWithRepeats(1, 1))

        assertEquals(BigInteger("1"), cWithRepeats(3, 0))
        assertEquals(BigInteger("3"), cWithRepeats(3, 1))
        assertEquals(BigInteger("6"), cWithRepeats(3, 2))
        assertEquals(BigInteger("10"), cWithRepeats(3, 3))

        assertEquals(BigInteger("1"), cWithRepeats(5, 0))
        assertEquals(BigInteger("5"), cWithRepeats(5, 1))
        assertEquals(BigInteger("15"), cWithRepeats(5, 2))
        assertEquals(BigInteger("35"), cWithRepeats(5, 3))
        assertEquals(BigInteger("70"), cWithRepeats(5, 4))
        assertEquals(BigInteger("126"), cWithRepeats(5, 5))


    }
}
