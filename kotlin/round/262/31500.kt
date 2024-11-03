import java.math.BigInteger
import kotlin.math.absoluteValue

fun main() {
    val radix = readln().toInt()
    val a = readln().customToInteger(radix)
    val b = readln().customToInteger(radix)
    println((a * b).integerToCustom(radix))
}

fun String.customToInteger(radix: Int): BigInteger =
    this.map { c -> if (c == '~') '-' else c.code - 33 }.toBigInteger(radix)

fun List<Any>.toBigInteger(radix: Int): BigInteger {
    val bRadix = radix.toBigInteger()
    return reversed().fold(BigInteger.ZERO to BigInteger.ONE) { acc: Pair<BigInteger, BigInteger>, value: Any ->
        when (value) {
            is Int -> (acc.second * value.toBigInteger() + acc.first) to (acc.second * bRadix)
            else -> -acc.first to BigInteger.ZERO
        }
    }.first
}

fun BigInteger.integerToCustom(radix: Int): String {
    if (this == BigInteger.ZERO) return "!"
    val negative = radix > 0 && this < BigInteger.ZERO
    val bRadix = radix.toBigInteger()
    val list = mutableListOf<Int>()
    var calc = if (negative) -this else this
    while (calc != BigInteger.ZERO) {
        var (quotient, remainder) = calc.divideAndRemainder(bRadix)
        if (radix < 0 && remainder < BigInteger.ZERO) {
            remainder -= bRadix
            quotient += BigInteger.ONE
        }
        list.add(remainder.toInt())
        calc = quotient
    }
    return "${if (negative) "~" else ""}${
        list.reversed().map { (it.absoluteValue + 33).toChar() }.joinToString(separator = "")
    }"
}