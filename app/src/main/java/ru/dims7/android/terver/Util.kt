package ru.dims7.android.terver

import java.math.BigInteger

fun BigInteger.toReadable(): String {
    val strValue = this.toString()
    return strValue.reversed()
        .mapIndexed { index, c -> if (index % 3 == 2 && index != strValue.length - 1) "'$c" else c.toString() }
        .reversed()
        .joinToString("")
}