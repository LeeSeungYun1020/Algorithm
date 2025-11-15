fun main() {
    readln()
    val q = readln().split(" ").map { it.toDouble() }
    val r = readln().split(" ").map { it.toDouble() }
    val intermediate =
        q.zip(r.asReversed().runningReduce { acc, d -> acc + d }.asReversed()).map { it.first / it.second }
    val norm = 1.0 / intermediate.sum()
    intermediate.joinToString(" ") { (it * norm).toString() }.let(::println)
}