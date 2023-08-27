import java.math.BigInteger

fun main() {
    repeat(readln().toInt()) {
        var (a, b) = readln().split(" ").map { it.toBigInteger() }
        a -= (a / b) * b

        val (i, n) = readln().split(" ").map { it.toBigInteger() }

        var pos = i
        while (pos < i + n) {
            print(quotient(a % b, b, pos))
            pos++
        }
        println()
    }
}

fun remainder(a: BigInteger, b: BigInteger, i: BigInteger) = (a % b) * BigInteger.TEN.modPow(i, b) % b

fun quotient(a: BigInteger, b: BigInteger, i: BigInteger) = remainder(a, b, i - BigInteger.ONE) * BigInteger.TEN / b