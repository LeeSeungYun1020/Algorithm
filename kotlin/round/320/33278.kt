import kotlin.math.min

fun main() {
    val (n, t) = readln().split(" ").let { it[0].toInt() to it[1].toLong() }
    List(n) {
        readln().split(" ").map { it.toLong() }.let {
            Tree(it[0], it[1], it[1] + t * it[0])
        }
    }.sortedBy { it.position }.windowed(2) { (previous, current) ->
        val capture = min(current.height, previous.constant - t * current.position).coerceAtLeast(0)
        if (previous.constant > current.constant) current.constant = previous.constant
        capture
    }.sum().run(::println)
}

class Tree(val position: Long, val height: Long, var constant: Long)