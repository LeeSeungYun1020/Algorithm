import kotlin.math.min

data class Pos(val x: Int, val y: Int)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    // 0 빈칸 1 벽 2 바이러스
    val board = List(N) { readln().split(" ").map { it.toInt() }.toMutableList() }
    var ans = N * M
    // 벽 3개 세우기
    for (i in 0 until N * M) {
        for (j in i + 1 until N * M) {
            for (k in j + 1 until N * M) {
                val pos1 = i / M to i % M
                val pos2 = j / M to j % M
                val pos3 = k / M to k % M
                if (board[pos1.first][pos1.second] == 0 && board[pos2.first][pos2.second] == 0 && board[pos3.first][pos3.second] == 0) {
                    board[pos1.first][pos1.second] = 1
                    board[pos2.first][pos2.second] = 1
                    board[pos3.first][pos3.second] = 1
                    // 안전 영역 크기 계산
                    val deque = ArrayDeque<Pos>()
                    val visited = List(N) { MutableList(M) { false } }
                    var count = 0
                    for (x in 0 until N)
                        for (y in 0 until M)
                            if (board[x][y] == 2) {
                                deque.add(Pos(x, y))
                                visited[x][y] = true
                                //count++
                            }
                    while (deque.isNotEmpty()) {
                        val first = deque.removeFirst()
                        val (x, y) = first
                        if (x - 1 >= 0 && !visited[x - 1][y] && board[x - 1][y] == 0) {
                            visited[x - 1][y] = true
                            count++
                            deque.add(Pos(x - 1, y))
                        }
                        if (y - 1 >= 0 && !visited[x][y - 1] && board[x][y - 1] == 0) {
                            visited[x][y - 1] = true
                            count++
                            deque.add(Pos(x, y - 1))
                        }
                        if (x + 1 < N && !visited[x + 1][y] && board[x + 1][y] == 0) {
                            visited[x + 1][y] = true
                            count++
                            deque.add(Pos(x + 1, y))
                        }
                        if (y + 1 < M && !visited[x][y + 1] && board[x][y + 1] == 0) {
                            visited[x][y + 1] = true
                            count++
                            deque.add(Pos(x, y + 1))
                        }
                    }

                    ans = min(count, ans)
                    board[pos1.first][pos1.second] = 0
                    board[pos2.first][pos2.second] = 0
                    board[pos3.first][pos3.second] = 0
                }
            }
        }
    }

    var safe = 0
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (board[i][j] == 0)
                safe++
        }
    }
    println(safe - 3 - ans)
}

