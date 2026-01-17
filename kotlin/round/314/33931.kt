fun main() {
    val (n, m) = readln().split(" ").map { it.toLong() }

    val remain = m % n
    println(
        if ((m / n) % 2 == 0L) remain
        else n - remain
    )
}