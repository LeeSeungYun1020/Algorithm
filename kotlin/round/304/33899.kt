fun main() {
    val checkMap = mapOf(
        '0' to 63, '8' to 63, '1' to 6, '2' to 27, '3' to 15, '4' to 38, '5' to 45, '6' to 61, '7' to 7, '9' to 47
    )
    val transitionMap = mapOf(
        1 to State(8, -1, 0),
        2 to State(32, 0, 1),
        4 to State(16, 0, 1),
        8 to State(1, 1, 0),
        16 to State(4, 0, -1),
        32 to State(2, 0, -1),
    )
    val (height, width) = readln().split(" ").map { it.toInt() }
    if (height == 1 && width == 1) return println("YES")
    val display = List(height) { readln().map { checkMap[it] ?: 0 } }
    val visited = List(height) { MutableList(width) { false } }
    val deque = ArrayDeque<Int>()
    val total = height * width
    var count = 1
    visited[0][0] = true
    deque.add(0)
    while (deque.isNotEmpty()) {
        val (i, j) = deque.removeFirst().let { it / height to it % height }
        transitionMap.entries.forEach { (condition, state) ->
            val nx = (i + state.x).takeIf { it in 0 until height } ?: return@forEach
            val ny = (j + state.y).takeIf { it in 0 until width } ?: return@forEach
            if (visited[nx][ny]) return@forEach
            if (display[i][j] and condition == 0) return@forEach
            if (display[nx][ny] and state.next == 0) return@forEach
            visited[nx][ny] = true
            count++
            if (count == total) {
                println("YES")
                return
            }
            deque.add(nx * height + ny)
        }
    }
    println("NO")
}

class State(val next: Int, val x: Int, val y: Int)
