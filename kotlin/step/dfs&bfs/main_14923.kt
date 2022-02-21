data class Position(val x:Int, val y: Int, val level: Int, val used: Boolean = false)

fun main() {
    // 미로 크기 N x M
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    // 시작 좌표
    val (Hx, Hy) = readLine()!!.split(" ").map { it.toInt() - 1 }
    // 종료 좌표
    val (Ex, Ey) = readLine()!!.split(" ").map { it.toInt() - 1 }
    // 행렬
    val maze = List(N) { readLine()!!.split(" ").map { it == "0" } }
    val visited = Array(N) { Array(M) { false } }
    val wallVisited = Array(N) { Array(M) { false } }
    val deque = ArrayDeque<Position>()
    deque.add(Position(Hx, Hy, 0))
    while (deque.isNotEmpty()) {
        val pos = deque.removeFirst()
        if (pos.x == Ex && pos.y == Ey) {
            println(pos.level)
            return
        }
        for (move in listOf(-1 to 0, 0 to -1, 1 to 0, 0 to 1)) {
            // 이동 가능 여부 확인
            val x = pos.x + move.first
            val y = pos.y + move.second
            if (x in 0 until  N && y in 0 until M && !visited[x][y]) {
                if (maze[x][y]) {
                    if (pos.used && !wallVisited[x][y]) {
                        deque.add(Position(x, y, pos.level + 1, pos.used))
                        wallVisited[x][y] = true
                    }
                    else if (!pos.used) {
                        deque.add(Position(x, y, pos.level + 1, pos.used))
                        visited[x][y] = true
                    }
                }
                else if (!pos.used) {
                    deque.add(Position(x, y, pos.level + 1, true))
                }
            }
        }
    }

    println(-1)
}