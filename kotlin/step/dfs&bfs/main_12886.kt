import kotlin.math.max
import kotlin.math.min

data class Rock(val a: Int, val b: Int)

fun main() {
    val (A, B, C) = readln().split(" ").map { it.toInt() }
    val sum = A + B + C
    if (sum % 3 != 0) {
        println(0)
        return
    }
    val deque = ArrayDeque<Rock>()
    deque.add(Rock(A, B))
    val visited = List(sum) { MutableList(sum) { false } }
    visited[A][B] = true
    while (deque.isNotEmpty()) {
        val (a, b) = deque.removeFirst()
        val c = sum - a - b
        if (a == b && b == c) {
            println(1)
            return
        }
        for ((x, y) in listOf(a to b, a to c, b to c)) {
            var px = x
            var py = y
            val pz = sum - px - py
            if (x < y) {
                px = x * 2
                py = y - x
            } else if (x > y) {
                px = x - y
                py = y * 2
            } else continue
            val tx = min(min(px, py), pz)
            val ty = max(max(px, py), pz)
            if (!visited[tx][ty]) {
                visited[tx][ty] = true
                deque.add(Rock(tx, ty))
            }
        }
    }
    println(0)
}