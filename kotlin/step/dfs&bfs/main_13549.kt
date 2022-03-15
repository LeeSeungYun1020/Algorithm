import kotlin.math.min

data class State(val position: Int, val time: Int)

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val visited = MutableList (200_000) { false }
    val deque = ArrayDeque<State>()
    visited[n] = true
    deque.add(State(n, 0))

    var ans = 200_000
    while (deque.isNotEmpty()) {
        val (pos, t) = deque.removeFirst()

        if (t >= ans) continue

        if (pos == k) {
            ans = min(ans, t)
            continue
        }


        if (k - pos > pos * 2 - k) {
            val move = pos * 2
            if (visited.getOrNull(move) == false) {
                visited[move] = true
                deque.addFirst(State(move, t))// 가중치가 적은 항목은 앞에 넣어야 함
            }
        }

        for (move in listOf(pos+1, pos-1))
            if (visited.getOrNull(move) == false) {
                visited[move] = true
                deque.add(State(move, t+1))
            }
    }
    println(ans)
}