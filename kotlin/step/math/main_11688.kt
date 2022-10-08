import kotlin.math.sqrt

fun findDivisor(n: Long): List<Long> {
    val divisors = mutableListOf<Long>()
    for (i in 1..sqrt(n.toDouble()).toLong()) {
        if (n % i == 0L) {
            divisors.add(i)
            if (n / i != i) divisors.add(n / i)
        }
    }
    return divisors.sorted()
}

fun lcm(a: Long, b: Long): Long = a * b / gcd(a, b)

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)

fun main() {
    // LCM(a, b, c) = L
    val (a, b, L) = readln().split(" ").map { it.toLong() }
    val lcmAB = lcm(a, b)
    if (L % lcmAB != 0L) {
        println(-1)
        return
    }
    for (c in findDivisor(L)){
        if (lcm(lcmAB, c) == L) {
            println(c)
            return
        }
    }
    println(-1)
}