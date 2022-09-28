import kotlin.math.max
import kotlin.reflect.jvm.internal.impl.incremental.components.Position

class Point(val x: Int, val y: Int)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val board = List(N) { readln().split(" ").map { it.toInt() } }
    val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }

    fun canMove(origin: Point, move: Point): Boolean {
        if (y1 == y2 && origin.y == y1 - 1 && move.y == y1 && origin.x == move.x && x1 <= origin.x && origin.x <= x2 - 1)
            return false
        if (x1 == x2 && origin.x == x1 - 1 && move.x == x1 && origin.y == move.y && y1 <= origin.y && origin.y <= y2 - 1)
            return false
        return true
    }

    val visited = List(N) { MutableList(M) { false } }
    var answer = -1
    fun dfs(pos: Point, sum: Int) {
        if (pos.x == N - 1 && pos.y == M - 1) {
            answer = max(answer, sum)
        }
        for (move in listOf(Point(pos.x + 1, pos.y), Point(pos.x, pos.y + 1))) {
            if (move.x >= N || move.y >= M || visited[move.x][move.y] || !canMove(pos, move))
                continue
            visited[move.x][move.y] = true
            dfs(move, sum + board[move.x][move.y])
            visited[move.x][move.y] = false
        }
    }
    dfs(Point(0, 0), board[0][0])
    if (answer == -1)
        println("Entity")
    else
        println(answer)
}