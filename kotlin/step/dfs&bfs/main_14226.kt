import kotlin.math.min

data class Operation(val display: Int, val board: Int, val count: Int)

fun main() {
    val s = readln().toInt()
    var ans = 2001
    val visited = List(ans) { MutableList(ans) { false } }
    val deque = ArrayDeque<Operation>()
    deque.add(Operation(1, 0, 0))
    visited[1][0] = true

    while (deque.isNotEmpty()) {
        val (display, board, count) = deque.removeFirst()
        if (display == s) {
            ans = min(ans, count)
        }
        if (display >= s || count >= ans)
            continue
        if (board != 0 && !visited[display+board][board]) {
            visited[display + board][board] = true
            deque.add(Operation(display + board, board, count + 1))
        }
        if (display != board) {
            visited[display][display] = true
            deque.add(Operation(display, display, count + 1))
        }
        if (display > 0 && !visited[display - 1][board]) {
            visited[display - 1][board] = true
            deque.add(Operation(display - 1, board, count + 1))
        }
    }
    println(ans)
}