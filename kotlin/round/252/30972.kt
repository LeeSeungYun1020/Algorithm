fun main() {
    val board = Board(List(size = readln().toInt()) { readln().split(" ").map { it.toInt() }.toMutableList() })
    println(List(size = readln().toInt()) {
        readln().split(" ").map { it.toInt() - 1 }
    }.joinToString(separator = "\n") { board.calculate(it).toString() })
}

fun Board.calculate(points: List<Int>): Int {
    return sum(points.mapIndexed { index: Int, point: Int ->
        if (index < 2) point + 1 else point - 1
    }) * 2 - sum(points)
}

class Board(private val board: List<MutableList<Int>>) {
    init {
        for (i in board.indices) {
            for (j in board[i].indices) {
                board[i][j] += (-this[i - 1, j - 1] + this[i - 1, j] + this[i, j - 1])
            }
        }
    }

    operator fun get(x: Int, y: Int): Int {
        return if (x in board.indices && y in board[x].indices) return board[x][y]
        else 0
    }

    fun sum(points: List<Int>): Int {
        val (x1, y1, x2, y2) = points
        return this[x1 - 1, y1 - 1] - this[x1 - 1, y2] - this[x2, y1 - 1] + this[x2, y2]
    }
}
