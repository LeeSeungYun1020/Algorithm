enum class Shape {
    BLANK, WALL, HOLE//, RED, BLUE
}

data class PositionMove(val red: Pair<Int, Int>, val blue: Pair<Int, Int>, val move: Int)
data class Position(val red: Pair<Int, Int>, val blue: Pair<Int, Int>)

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    var red = 0 to 0
    var blue = 0 to 0
    var hole = 0 to 0
    val board = List(N) {
        readLine()!!.mapIndexed { index, char ->
            when (char) {
                '.' -> Shape.BLANK
                '#' -> Shape.WALL
                'O' -> {
                    hole = it to index
                    Shape.HOLE
                }
                'R' -> {
                    red = it to index
                    Shape.BLANK
                }
                else -> {
                    blue = it to index
                    Shape.BLANK
                }
            }
        }
    }
    val deque = ArrayDeque<PositionMove>()
    deque.add(PositionMove(red, blue, 0))
    val visited = mutableMapOf(Position(red, blue) to true)

    fun moveHorizontal(target: Pair<Int, Int>, compare: Pair<Int, Int>, check: Boolean, left: Boolean): Pair<Int, Int> {
        var newTarget = target
        val range = if (left) (target.second - 1).downTo(1) else (target.second + 1)..(M - 2)
        for (i in range) {
            when (board[target.first][i]) {
                Shape.HOLE -> {
                    newTarget = target.first to i
                    break
                }
                Shape.BLANK -> {
                    if (check && i == compare.second)
                        break
                    newTarget = target.first to i
                }
                Shape.WALL -> {
                    break
                }
            }
        }
        return newTarget
    }

    fun moveVertical(target: Pair<Int, Int>, compare: Pair<Int, Int>, check: Boolean, up: Boolean): Pair<Int, Int> {
        var newTarget = target
        val range = if (up) (target.first - 1).downTo(1) else (target.first + 1)..(N - 2)
        for (i in range) {
            when (board[i][target.second]) {
                Shape.HOLE -> {
                    newTarget = i to target.second
                    break
                }
                Shape.BLANK -> {
                    if (check && i == compare.first)
                        break
                    newTarget = i to target.second
                }
                Shape.WALL -> {
                    break
                }
            }
        }
        return newTarget
    }

    fun addIfNotVisited(red: Pair<Int, Int>, blue: Pair<Int, Int>, move: Int) {
        if (!visited.getOrDefault(Position(red, blue), false)) {
            deque.add(
                PositionMove(
                    red,
                    blue,
                    move
                )
            )
            visited[Position(red, blue)] = true
        }
    }

    while (deque.isNotEmpty()) {
        val pos = deque.removeFirst()
        if (pos.move > 10) {
            println(-1)
            return
        }
        if (pos.blue == hole) {
            continue
        }
        if (pos.red == hole) {
            println(pos.move)
            return
        }

        // 오른쪽 왼쪽
        // 같은 열에 있는 경우
        if (pos.red.first == pos.blue.first) {
            // RB인 경우 - 왼쪽: R 먼저 이동 후 B 이동, 오른쪽: B 먼저 이동 후 R 이동
            // BR인 경우 - 왼쪽: B 먼저 이동 후 R 이동, 오른쪽: R 먼저 이동 후 B 이동
            val newRed = moveHorizontal(pos.red, pos.blue, check = false, left = pos.red.second < pos.blue.second)
            addIfNotVisited(
                newRed,
                moveHorizontal(pos.blue, newRed, check = true, left = pos.red.second < pos.blue.second),
                pos.move + 1
            )

            val newBlue = moveHorizontal(pos.blue, pos.red, check = false, left = pos.red.second > pos.blue.second)
            addIfNotVisited(
                moveHorizontal(pos.red, newBlue, check = true, left = pos.red.second > pos.blue.second),
                newBlue,
                pos.move + 1
            )
        }
        // RB 별도 고려하는 경우
        else {
            for (b in listOf(true, false)) {
                addIfNotVisited(
                    moveHorizontal(pos.red, pos.blue, check = false, left = b),
                    moveHorizontal(pos.blue, pos.red, check = false, left = b),
                    pos.move + 1
                )
            }
        }

        // 위 아래
        // 같은 행에 있는 경우
        if (pos.red.second == pos.blue.second) {
            // R/B인 경우 - 위쪽: R 먼저 이동 후 B 이동, 아래쪽: B 먼저 이동 후 R 이동
            // B/R인 경우 - 위쪽: B 먼저 이동 후 R 이동, 아래쪽: R 먼저 이동 후 B 이동
            val newRed = moveVertical(pos.red, pos.blue, check = false, up = pos.red.first < pos.blue.first)
            addIfNotVisited(
                newRed,
                moveVertical(pos.blue, newRed, check = true, up = pos.red.first < pos.blue.first),
                pos.move + 1
            )
            val newBlue = moveVertical(pos.blue, pos.red, check = false, up = pos.red.first > pos.blue.first)
            addIfNotVisited(
                moveVertical(pos.red, newBlue, check = true, up = pos.red.first > pos.blue.first),
                newBlue,
                pos.move + 1
            )
        }
        // R/B 별도 고려하는 경우
        else {
            for (b in listOf(true, false)) {
                addIfNotVisited(
                    moveVertical(pos.red, pos.blue, check = false, up = b),
                    moveVertical(pos.blue, pos.red, check = false, up = b),
                    pos.move + 1
                )

            }
        }
    }
    println(-1)
}