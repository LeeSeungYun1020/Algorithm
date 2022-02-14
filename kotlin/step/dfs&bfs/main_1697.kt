import kotlin.math.max

fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val visited = BooleanArray(max(k, n) * 2 + 1) { false }
    val deq = ArrayDeque<Pair<Int, Int>>()
    deq.add(n to 0)
    visited[n] = true
    while (deq.isNotEmpty()) {
        val (pos, level) = deq.removeFirst()
        if (pos == k) {
            println(level)
            return
        }
        for (i in intArrayOf(pos + 1, pos - 1, pos * 2)) {
            if (visited.getOrNull(i) == false) {
                visited[i] = true
                deq.add(i to level + 1)
            }
        }
    }
}