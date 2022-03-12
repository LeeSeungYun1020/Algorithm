import kotlin.math.min

data class Move(val x: Int, val y: Int, val broken: Int)

fun main() {
    val (m, n) = readln().split(" ").map{ it.toInt() }
    val room = List(n) { readln().map { it == '0' } }
    val visited = List(n) { MutableList(m) { m + n } }
    if (m == 1 && n == 1) {
        println(0)
        return
    }
    var ans = m + n - 3
    val deque = ArrayDeque<Move>()
    deque.add(Move(0, 0, 0))
    visited[0][0] = 0
    while (deque.isNotEmpty()) {
        val (x, y, broken) = deque.removeFirst()
        if (broken >= ans) continue
        if (x == n-1 && y == m-1) {
            ans = min(ans, broken)
        } else {
            for ((mX, mY) in listOf((x+1 to y), (x to y+1), (x-1 to y), (x to y-1))) {
                val isRoom = room.getOrNull(mX)?.getOrNull(mY) ?: continue
                val brk = if (isRoom) broken else broken + 1
                if (visited[mX][mY] > brk) {
                    visited[mX][mY] = brk
                    deque.add(Move(mX, mY, brk))
                }
            }
        }
    }
    println(ans)
}