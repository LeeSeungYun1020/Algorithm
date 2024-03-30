fun main() {
    repeat(readln().toInt()) {
        readln()
        val input =
            readln().split(" ").map { it.toInt() }.toSortedSet().windowed(2) { it[1] - it[0] }
                .filterNot { it == 0 }
        if (input.isEmpty()) {
            println("INFINITY")
        } else {
            println(input.reduce { acc, i -> gcd(acc, i) })
        }
    }
}

fun gcd(a: Int, b: Int): Int = when {
    a % b == 0 -> b
    else -> gcd(b, a % b)
}