import kotlin.math.abs

fun main() {
    val (a, b, c) = readln().trim().split(" ").map { it.toLong() }
    fun cost(x: Long, y: Long): Long {
        return abs(x - a) + abs(y - b) + abs(x * y - c)
    }

    var answer = cost(a, b)
    fun update(x: Long, y: Long) {
        if (x <= 0L || y <= 0L) return
        answer = minOf(answer, cost(x, y))
    }

    var left = 1L
    while (left <= c) {
        val quotient = c / left
        val right = c / quotient
        update(right, quotient)
        update(left, quotient + 1)
        left = right + 1
    }

    if (a > c) {
        update(a, 1L)
    } else {
        update(c + 1, 1L)
    }

    println(answer)
}