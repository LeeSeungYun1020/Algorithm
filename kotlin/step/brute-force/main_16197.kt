import kotlin.math.min


fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    var coinA = -1 to -1
    var coinB = -1 to -1
    val board = List(N) { x ->
        readln().mapIndexed { y, char ->
            when (char) {
                'o' -> {
                    if (coinA.first == -1) coinA = x to y else coinB = x to y
                    true
                }
                '.' -> true
                else -> false
            }
        }
    }

    var push = 11

    fun Pair<Int, Int>.isOnBoard() = first in 0 until N && second in 0 until M
    fun dfs(posA: Pair<Int, Int>, posB: Pair<Int, Int>, level: Int) {
        if (level > 10 || level >= push)
            return
        val isAOnBoard = posA.isOnBoard()
        val isBOnBoard = posB.isOnBoard()
        if (isAOnBoard && isBOnBoard) {
            for (move in listOf(-1 to 0, 0 to -1, 0 to 1, 1 to 0)) {
                dfs(
                    if (board.getOrNull(posA.first + move.first)?.getOrNull(posA.second + move.second) != false) {
                        (posA.first + move.first) to (posA.second + move.second)
                    } else {
                        posA
                    },
                    if (board.getOrNull(posB.first + move.first)?.getOrNull(posB.second + move.second) != false) {
                        (posB.first + move.first) to (posB.second + move.second)
                    } else {
                        posB
                    },
                level + 1
                )

            }
        } else if ((isAOnBoard && !isBOnBoard) || (!isAOnBoard && isBOnBoard)) {
            push = min(push, level)
        } else {
            return
        }
    }
    dfs(coinA, coinB, 0)
    if (push == 11)
        println(-1)
    else
        println(push)
}
