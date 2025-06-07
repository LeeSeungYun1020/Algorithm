import kotlin.math.min

fun main() {
    val time = List(12) { readln().split(" ").map { it.toInt() } }
    var first = 0
    var second = 0
    for (start in 0..8 step 2) {
        val nSecond = first + time[start][start + 1]
        val nFirst = second + time[start + 1][start]
        first = min(nFirst + time[start][start + 2], nSecond + time[start + 1][start + 2])
        second = min(nFirst + time[start][start + 3], nSecond + time[start + 1][start + 3])
    }
    println(min(first + time[10][11], second + time[11][10]))
}