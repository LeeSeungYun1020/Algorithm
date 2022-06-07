import kotlin.math.min

data class State(val now: Int, val price: Int)

fun main() {
    val city = readln().toInt()
    val bus = readln().toInt()
    val board = List(city) { i ->  MutableList(city) { j -> if (i == j) 0 else Int.MAX_VALUE } }
    for (i in 1..bus) {
        val (start, end, price) = readln().split(" ").map { it.toInt() }
        board[start-1][end-1] = min(board[start-1][end-1], price)
    }
    val (start, end) = readln().split(" ").map { it.toInt() - 1 }
    val deque = ArrayDeque<State>()
    deque.add(State(start, 0))
    val visited = MutableList(city) { Int.MAX_VALUE }
    visited[start] = 0
    while (deque.isNotEmpty()) {
        val (now, price) = deque.removeFirst()
        if (now == end) {
            visited[end] = min(visited[end], price)
        } else {
            for (i in 0 until city) {
                val calc = price + board[now][i]
                if (board[now][i] != Int.MAX_VALUE && visited[i] > calc) {
                    visited[i] = calc
                    deque.add(State(i, calc))
                }
            }
        }
    }
    println(visited[end])
}
