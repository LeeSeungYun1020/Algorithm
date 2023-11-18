fun main() {
    val n = readln().toInt()
    var zeroCount = 0
    val points = List(n) {
        val point = readln().toPoint()
        if (point.isZero) zeroCount++
        point
    }

    var route = 0
    val visited = MutableList(n) { false }
    fun dfs(level: Int, position: Point, count: Int, direction: Direction) {
        if (level == n - 1) {
            if (position.isZero) {
                val zeroDirection = when {
                    0 > position.x -> Direction.N
                    0 < position.x -> Direction.S
                    0 > position.y -> Direction.E
                    else -> Direction.W
                }
                if (direction != zeroDirection) route++
            }
            return
        }
        if (count == 0) {
            return
        }
        for ((index, move) in points.withIndex()) {
            if (!visited[index] && (position.x == move.x || position.y == move.y)) {
                val nextDirection = when {
                    move.x > position.x -> Direction.N
                    move.x < position.x -> Direction.S
                    move.y > position.y -> Direction.E
                    else -> Direction.W
                }
                if (nextDirection == direction) continue

                visited[index] = true
                dfs(level + 1, move, if (move.isZero) count - 1 else count, nextDirection)
                visited[index] = false
            }
        }
    }

    for ((index, start) in points.withIndex()) {
        if (start.isZero) {
            val direction = when {
                start.x > 0 -> Direction.N
                start.x < 0 -> Direction.S
                start.y > 0 -> Direction.E
                else -> Direction.W
            }
            visited[index] = true
            dfs(0, start, zeroCount - 1, direction)
            visited[index] = false
        }
    }
    println(route)
}

fun String.toPoint() = split(" ").map { it.toInt() }.let { Point(it[0], it[1], it[0] == 0 || it[1] == 0) }

class Point(val x: Int, val y: Int, val isZero: Boolean)

enum class Direction {
    N, E, S, W
}