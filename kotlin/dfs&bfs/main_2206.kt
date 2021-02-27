import kotlin.math.min

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val visited = Array(n) { Array(m) { booleanArrayOf(false, false) } }
    val map = List(n) { readLine()!! }
    val deq = ArrayDeque<Position>()
    deq.add(Position(0, 0, 1, false))
    visited[0][0][0] = true
    while (deq.isNotEmpty()) {
        val pos = deq.removeFirst()
        if (pos.x == n - 1 && pos.y == m - 1) {
            println(pos.level)
            return
        }
        for (i in intArrayOf(pos.x + 1, pos.x - 1)) {
            if (map.getOrNull(i)?.get(pos.y) == '0' && !visited[i][pos.y][if (pos.isBreak) 1 else 0]) {
                visited[i][pos.y][if (pos.isBreak) 1 else 0] = true
                deq.add(Position(i, pos.y, pos.level + 1, pos.isBreak))
            }
            if (!pos.isBreak && map.getOrNull(i)?.get(pos.y) == '1' && !visited[i][pos.y][1]) {
                visited[i][pos.y][1] = true
                deq.add(Position(i, pos.y, pos.level + 1, true))
            }
        }
        for (i in intArrayOf(pos.y + 1, pos.y - 1)) {
            if (map[pos.x].getOrNull(i) == '0' && !visited[pos.x][i][if (pos.isBreak) 1 else 0]) {
                visited[pos.x][i][if (pos.isBreak) 1 else 0] = true
                deq.add(Position(pos.x, i, pos.level + 1, pos.isBreak))
            }
            if (!pos.isBreak && map[pos.x].getOrNull(i) == '1' && !visited[pos.x][i][1]) {
                visited[pos.x][i][1] = true
                deq.add(Position(pos.x, i, pos.level + 1, true))
            }
        }
    }
    println(-1)
}

class Position(val x: Int, val y: Int, val level: Int, val isBreak: Boolean)