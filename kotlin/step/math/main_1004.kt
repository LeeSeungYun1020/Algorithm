import kotlin.math.pow

fun main() {
    val t = readln().toInt()
    for (i in 1..t) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
        val n = readln().toInt()
        var count = 0
        for (j in 1..n) {
            val (cx, cy, r) = readln().split(" ").map { it.toDouble() }
            if (((cx - x1).pow(2) + (cy - y1).pow(2) <= r.pow(2)) xor
                ((cx - x2).pow(2) + (cy - y2).pow(2) <= r.pow(2)))
                count++
        }
        println(count)
    }
}