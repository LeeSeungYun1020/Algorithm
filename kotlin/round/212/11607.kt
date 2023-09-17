import kotlin.math.min

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val board = List(n) { readln().map { it.digitToInt() } }

    val visit = List(n) { MutableList(m) { Int.MAX_VALUE } }
    visit[0][0] = 0

    val deque = ArrayDeque<Position>()
    deque.add(Position(0, 0, 0))

    var answer = Int.MAX_VALUE
    while (deque.isNotEmpty()) {
        val pos = deque.removeFirst()
        if (pos.x == n - 1 && pos.y == m - 1) {
            answer = min(answer, pos.level)
            continue
        }
        if (pos.level >= answer)
            continue

        val move = board[pos.x][pos.y]
        for ((mx, my) in listOf(
                pos.x + move to pos.y,
                pos.x - move to pos.y,
                pos.x to pos.y + move,
                pos.x to pos.y - move
        )) {
            if (mx in 0 until n && my in 0 until m && visit[mx][my] > pos.level + 1) {
                visit[mx][my] = pos.level + 1
                deque.add(Position(mx, my, pos.level + 1))
            }
        }
    }

    when (answer) {
        Int.MAX_VALUE -> {
            println("IMPOSSIBLE")
        }

        else -> {
            println(answer)
        }
    }
}

class Position(val x: Int, val y: Int, val level: Int)