data class State(val x: Int, val y: Int, val k: Int, val distance: Int)

fun main() {
    val (N, M, K) = readln().split(" ").map { it.toInt() }
    val board = List(N) {
        readln().map {
            when (it) {
                '0' -> true
                else -> false
            }
        }
    }
    val visited = List(N) { List(M) { MutableList(K+1) { false } } }
    val que = ArrayDeque<State>()
    visited[0][0][0] = true
    que.add(State(0, 0, 0, 1))
    while (que.isNotEmpty()) {
        val (x, y, k, distance) = que.removeFirst()
        if (x == N - 1 && y == M - 1) {
            println(distance)
            return
        }
        for (pos in listOf(x - 1 to y, x + 1 to y, x to y - 1, x to y + 1)) {
            if (pos.first < 0 || pos.first >= N || pos.second < 0 || pos.second >= M)
                continue
            if (board[pos.first][pos.second] && !visited[pos.first][pos.second][k]) {
                visited[pos.first][pos.second][k] = true
                que.add(State(pos.first, pos.second, k, distance + 1))
            } else if (!board[pos.first][pos.second] && k < K) {
                var pass = true
                for (dk in 0..k+1) {
                    if (visited[pos.first][pos.second][dk]) {
                        pass = false
                        break
                    }
                }
                if (pass) {
                    visited[pos.first][pos.second][k + 1] = true
                    que.add(State(pos.first, pos.second, k + 1, distance + 1))
                }
            }
        }
    }
    println(-1)
}