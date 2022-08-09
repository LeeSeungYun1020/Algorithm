class Solution {

    private fun List<MutableList<Boolean>>.rotate(): List<MutableList<Boolean>> {
        val newShape = List(this[0].size) { MutableList(this.size) { false } }
        for (i in newShape.indices) {
            for (j in newShape[0].indices) {
                newShape[i][j] = this[j][this[0].size - i - 1]
            }
        }
        return newShape
    }

    fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
        var answer: Int = 0

        val gameVisited = List(game_board.size) { MutableList(game_board[0].size) { false } }
        fun findShapeFromGameTable(x: Int, y: Int): List<MutableList<Boolean>> {
            val deque = ArrayDeque<Pair<Int, Int>>()
            val shape = ArrayDeque<Pair<Int, Int>>()
            deque.add(x to y)
            shape.add(x to y)
            gameVisited[x][y] = true
            while (deque.isNotEmpty()) {
                val (posX, posY) = deque.removeFirst()
                for ((mx, my) in listOf(posX - 1 to posY, posX + 1 to posY, posX to posY - 1, posX to posY + 1)) {
                    if (mx in game_board.indices && my in game_board[0].indices &&
                        game_board[mx][my] == 0 && !gameVisited[mx][my]
                    ) {
                        deque.add(mx to my)
                        shape.add(mx to my)
                        gameVisited[mx][my] = true
                    }
                }
            }
            val minX = shape.minOf { it.first }
            val maxX = shape.maxOf { it.first }
            val minY = shape.minOf { it.second }
            val maxY = shape.maxOf { it.second }
            val shapeBoard = List(maxX - minX + 1) { MutableList(maxY - minY + 1) { false } }
            for ((x, y) in shape) {
                shapeBoard[x - minX][y - minY] = true
            }
            return shapeBoard
        }

        val shapeList = mutableListOf<List<MutableList<Boolean>>>()
        for (i in game_board.indices) {
            for (j in game_board[0].indices) {
                if (game_board[i][j] == 0 && !gameVisited[i][j]) {
                    shapeList += findShapeFromGameTable(i, j)
                }
            }
        }

        val blockVisited = List(table.size) { MutableList(table[0].size) { false } }
        fun findShapeFromTable(x: Int, y: Int): List<MutableList<Boolean>> {
            val deque = ArrayDeque<Pair<Int, Int>>()
            val shape = ArrayDeque<Pair<Int, Int>>()
            deque.add(x to y)
            shape.add(x to y)
            blockVisited[x][y] = true
            while (deque.isNotEmpty()) {
                val (posX, posY) = deque.removeFirst()
                for ((mx, my) in listOf(posX - 1 to posY, posX + 1 to posY, posX to posY - 1, posX to posY + 1)) {
                    if (mx in table.indices && my in table[0].indices &&
                        table[mx][my] == 1 && !blockVisited[mx][my]
                    ) {
                        deque.add(mx to my)
                        shape.add(mx to my)
                        blockVisited[mx][my] = true
                    }
                }
            }
            val minX = shape.minOf { it.first }
            val maxX = shape.maxOf { it.first }
            val minY = shape.minOf { it.second }
            val maxY = shape.maxOf { it.second }
            val shapeBoard = List(maxX - minX + 1) { MutableList(maxY - minY + 1) { false } }
            for ((x, y) in shape) {
                shapeBoard[x - minX][y - minY] = true
            }
            return shapeBoard
        }
        for (i in table.indices) {
            for (j in table[0].indices) {
                if (table[i][j] == 1 && !blockVisited[i][j]) {
                    val shape = findShapeFromTable(i, j)
                    val count = shape.sumOf { it.count { it } }
                    if (shapeList.remove(shape)) {
                        answer += count
                    } else if (shapeList.remove(shape.rotate())) {
                        answer += count
                    } else if (shapeList.remove(shape.rotate().rotate())) {
                        answer += count
                    } else if (shapeList.remove(shape.rotate().rotate().rotate())) {
                        answer += count
                    }
                }
            }
        }

        return answer
    }
}