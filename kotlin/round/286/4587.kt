fun main() {
    val result = StringBuilder()
    while (true) {
        val (numerator, denominator) = readln().split(" ").map { it.toLong() }
        when (numerator) {
            0L -> break
            1L -> result.appendLine(denominator)
            else -> {
                var target = 2L
                var calcNumerator = numerator
                var calcDenominator = denominator
                while (calcNumerator != 0L && target < 1_000_000L) {
                    val gcd = gcd(target, calcDenominator)
                    var temNumerator = (calcNumerator * target - calcDenominator) / gcd
                    if (temNumerator < 0) {
                        target++
                        continue
                    }
                    var temDenominator = calcDenominator / gcd * target
                    val temGcd = gcd(temNumerator, temDenominator)
                    temNumerator /= temGcd
                    temDenominator /= temGcd
                    if (temDenominator < 1_000_000L) {
                        result.append("$target ")
                        calcNumerator = temNumerator
                        calcDenominator = temDenominator
                    } else {
                        target++
                    }
                }
                result.appendLine()
            }
        }
    }
    print(result)
}

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
