fun main() {
    readln()
    println(
        readln().split(" ").map { it.toInt() }.sortedByDescending { it }.zipWithNext { a, b -> a - b }
            .reduce { acc, i -> gcd(acc, i) }
    )
}

fun gcd(a: Int, b: Int): Int {
    return when {
        a < b -> gcd(b, a)
        b == 0 -> a
        else -> gcd(b, a % b)
    }
}