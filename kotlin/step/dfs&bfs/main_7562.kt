fun main() {
    val count = readLine()!!.toInt()
    for (c in 1..count) {
        val length = readLine()!!.toInt()
        val visited = Array(length) { BooleanArray(length) { false } }
        val start = readLine()!!.split(' ').map { it.toInt() }
        val end = readLine()!!.split(' ').map { it.toInt() }
        val deq = ArrayDeque<Position>()
        deq.add(Position(start.first(), start.last(), 0))
        visited[start.first()][start.last()]
        while (deq.isNotEmpty()) {
            val pos = deq.removeFirst()
            if (pos.x == end.first() && pos.y == end.last()) {
                println(pos.level)
                break
            }
            listOf(Position(pos.x - 2, pos.y - 1, pos.level + 1),
                    Position(pos.x - 2, pos.y + 1, pos.level + 1),
                    Position(pos.x - 1, pos.y - 2, pos.level + 1),
                    Position(pos.x - 1, pos.y + 2, pos.level + 1),
                    Position(pos.x + 1, pos.y - 2, pos.level + 1),
                    Position(pos.x + 1, pos.y + 2, pos.level + 1),
                    Position(pos.x + 2, pos.y - 1, pos.level + 1),
                    Position(pos.x + 2, pos.y + 1, pos.level + 1)
            ).forEach {
                if (visited.elementAtOrNull(it.x)?.elementAtOrNull(it.y) == false) {
                    visited[it.x][it.y] = true
                    deq.add(it)
                }
            }
        }
    }
}

class Position(val x: Int, val y: Int, val level: Int)