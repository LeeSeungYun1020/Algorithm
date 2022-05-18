data class State(val level: Int, val pos: Int)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val move = buildMap<Int, Int> {
        for (i in 0 until N + M) {
            val (k, v) = readln().split(" ").map { it.toInt() }
            put(k, v)
        }
    }

    val visited = MutableList(101) { false }
    val deque = ArrayDeque<State>()
    deque.add(State(0, 1))
    visited[1] = true
    while (deque.isNotEmpty()) {
        val first = deque.removeFirst()
        if (first.pos > 100)
            return
        if (first.pos == 100) {
            println(first.level)
            return
        }
        for (i in 1..6) {
            val target = move.getOrDefault(first.pos + i, first.pos + i)
            if (target <= 100 && !visited[target]) {
                visited[target] = true
                deque.add(State(first.level + 1, target))
            }
        }
    }
}

