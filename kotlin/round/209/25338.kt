import kotlin.math.max

fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }
    fun calculate(x: Int): Int = max(a * (x - b) * (x - b) + c, d)

    var count = 0
    for (i in 1..readln().toInt()) {
        val (width, height) = readln().split(" ").map { it.toInt() }
        if (height >= b && width == calculate(height)) count++
    }
    println(count)
}