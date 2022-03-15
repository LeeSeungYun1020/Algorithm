data class State(val position: Int, val time: Int)

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val visited = MutableList (200_000) { -1 }
    val deque = ArrayDeque<State>()
    visited[n] = -2
    deque.add(State(n, 0))
    while (deque.isNotEmpty()) {
        val (pos, t) = deque.removeFirst()
        if (pos == k) {
            println(t)
            val route = ArrayDeque<Int>()
            var next = pos
            while (next != -2) {
                route.addFirst(next)
                next = visited[next]
            }
            for (e in route)
                print("$e ")
            return
        }


        for (move in listOf(pos*2, pos+1, pos-1))
            if (visited.getOrNull(move) == -1) {
                visited[move] = pos
                deque.add(State(move, t+1))
            }
    }
}