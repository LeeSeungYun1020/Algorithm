import Type.*

fun main() {
    val (height, _) = readln().split(" ").map { it.toInt() }
    var startX = 0
    var startY = 0
    var endX = 0
    var endY = 0
    val board: Board = List(height) { i ->
        readln().mapIndexed { j, char ->
            when (char) {
                'S' -> {
                    startX = i
                    startY = j
                    BLANK
                }
                'E' -> {
                    endX = i
                    endY = j
                    BLANK
                }
                '#' -> WALL
                else -> BLANK
            }
        }.toMutableList()
    }
    board.setAdjacent()

    val distance = List(board.size) { MutableList(board[it].size) { Int.MAX_VALUE } }
    val deque = ArrayDeque<Step>()
    deque.add(Step(startX, startY, 0))
    while (deque.isNotEmpty()) {
        val (x, y, level) = deque.removeFirst()

        if (distance[x][y] <= level) {
            continue
        }
        distance[x][y] = level

        val current = board[x][y]
        for (point in listOf(x - 1 to y, x to y - 1, x to y + 1, x + 1 to y)) {
            val move = board.getOrNull(point.first)?.getOrNull(point.second)
            if (current == ADJACENT && move == ADJACENT) {
                deque.addFirst(Step(point.first, point.second, level))
            } else if (move == BLANK || move == ADJACENT) {
                deque.addLast(Step(point.first, point.second, level + 1))
            }
        }
    }
    println(distance[endX][endY])
}

typealias Board = List<MutableList<Type>>

private fun Board.setAdjacent() {
    for (i in indices) {
        for (j in this[i].indices) {
            if (this[i][j] == BLANK &&
                (this.getOrNull(i - 1)?.get(j) == WALL ||
                        this[i].getOrNull(j - 1) == WALL ||
                        this[i].getOrNull(j + 1) == WALL ||
                        this.getOrNull(i + 1)?.get(j) == WALL)
            ) {
                this[i][j] = ADJACENT
            }
        }
    }
}

enum class Type {
    WALL, BLANK, ADJACENT,
}

data class Step(val x: Int, val y: Int, val level: Int)