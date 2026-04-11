import kotlin.math.max
import kotlin.math.min

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val rooms = List(n) { readln().split(" ").map { it.toLong() }.toMutableList() }
    val visit = List(n) { MutableList(m) { false } }
    val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
    val wall = when {
        x1 == 0 && x2 == 0 -> Wall.None
        y1 == 0 && y2 == 0 -> Wall.None
        x1 == n && x2 == n -> Wall.None
        y1 == m && y2 == m -> Wall.None
        x1 == x2 && y1 != y2 -> {
            val start = min(y1, y2)
            val end = max(y1, y2)
            if (start == 0 && end == m) {
                println("Entity")
                return
            }
            Wall.Horizontal(x1, start until end)
        }
        x1 != x2 && y1 == y2 -> {
            val start = min(x1, x2)
            val end = max(x1, x2)
            if (start == 0 && end == n) {
                println("Entity")
                return
            }
            Wall.Vertical(y1, start until end)
        }
        else -> Wall.None
    }
    for (i in rooms.indices) {
        for (j in rooms[i].indices) {
            when {
                i == 0 && j == 0 -> {
                    visit[i][j] = true
                }
                wall is Wall.Horizontal && i == wall.pos && j in wall.range -> {
                    if (j > 0 && visit[i][j - 1]) {
                        visit[i][j] = true
                        rooms[i][j] += rooms[i][j - 1]
                    }
                }
                wall is Wall.Vertical && j == wall.pos && i in wall.range -> {
                    if (i > 0 && visit[i - 1][j]) {
                        visit[i][j] = true
                        rooms[i][j] += rooms[i - 1][j]
                    }
                }
                i == 0 -> {
                    if (visit[i][j - 1]) {
                        visit[i][j] = true
                        rooms[i][j] += rooms[i][j - 1]
                    }
                }
                j == 0 -> {
                    if (visit[i - 1][j]) {
                        visit[i][j] = true
                        rooms[i][j] += rooms[i - 1][j]
                    }
                }
                visit[i - 1][j] && visit[i][j - 1] -> {
                    visit[i][j] = true
                    rooms[i][j] += max(rooms[i - 1][j], rooms[i][j - 1])
                }
                visit[i - 1][j] -> {
                    visit[i][j] = true
                    rooms[i][j] += rooms[i - 1][j]
                }
                visit[i][j - 1] -> {
                    visit[i][j] = true
                    rooms[i][j] += rooms[i][j - 1]
                }
            }
        }
    }
    if (visit.last().last()) {
        println(rooms.last().last())
    } else {
        println("Entity")
    }
}

sealed interface Wall {
    class Horizontal(val pos: Int, val range: IntRange) : Wall
    class Vertical(val pos: Int, val range: IntRange) : Wall
    object None : Wall
}