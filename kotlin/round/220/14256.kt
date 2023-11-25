import kotlin.math.sqrt

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val prime = buildPrimeMap().filter { it.value }.keys

    fun calcOdd(a: Int): Int {
        var tem = a
        var odd = 1
        for (p in prime) {
            if (tem == 1 || p > tem) break
            var isDouble = true
            while (tem % p == 0 && tem != 1) {
                tem /= p
                isDouble = !isDouble
            }
            if (!isDouble) {
                odd *= p
            }
        }
        if (tem != 1) {
            odd *= tem
        }
        return odd
    }
    println((1..n).sumOf { sqrt(m.toDouble() / calcOdd(it)).toInt() })
}

fun buildPrimeMap() = buildMap<Int, Boolean> {
    for (i in 2..278) set(i, true)
    for (i in 2..278) {
        if (this[i] == true) {
            for (j in i..278) {
                val target = i * j
                if (i * j > 278) break
                set(target, false)
            }
        }
    }
}