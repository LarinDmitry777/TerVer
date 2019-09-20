package ru.dims7.android.terver

import java.math.BigInteger
import kotlin.math.max

fun fact(n: Int): BigInteger {
    require(n >= 0) { "Value 'n' must be non negative" }
    return generateSequence(BigInteger("1")) { it + BigInteger("1") }
        .take(max(1, n))
        .reduce { acc, i -> acc * i }
}

fun Int.pow(n: Int): BigInteger {
    require(n >= 0) { "Value 'n' must be non negative" }
    if (n == 0) return BigInteger("1")
    return generateSequence { BigInteger(this.toString()) }
        .take(n)
        .reduce { acc, i -> acc * i }
}

fun pWithoutRepeats(n: Int): BigInteger {
    checkValues(n)
    return fact(n)
}

fun cWithoutRepeats(n: Int, k: Int): BigInteger{
    checkValues(n, k)
    return fact(n) / fact(k) / fact(n - k)
}

fun cWithRepeats(n: Int, k: Int): BigInteger {
    checkValues(n, k)
    if (n + k ==  1) {
        return BigInteger("1")
    }
    return cWithoutRepeats(n + k - 1, k)
}

fun aWithoutRepeats(n: Int, k: Int): BigInteger {
    checkValues(n, k)
    return fact(n) / fact(n - k)
}

fun aWithRepeats(n: Int, k: Int): BigInteger {
    checkValues(n, k)
    return n.pow(k)
}

private fun checkValues(n: Int, k: Int = 0) {
    require(n > 0) { "Value 'n' must be positive $n" }
    require(k >= 0) { "Value 'k' must be non negative" }
    require(k <= n) { "'n' must be more than 'k'" }
}