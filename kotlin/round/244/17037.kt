fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val board = List(1001) { MutableList(1001) { 0 } }
    repeat(n) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
        board[x1][y1]++
        board[x2][y1]--
        board[x1][y2]--
        board[x2][y2]++
    }

    for (i in 1..1000) {
        for (j in 0..1000) {
            board[i][j] += board[i - 1][j]
        }
    }
    for (j in 1..1000) {
        for (i in 0..1000) {
            board[i][j] += board[i][j - 1]
        }
    }

    var count = 0
    for (i in 0..1000) {
        for (j in 0..1000) {
            if (board[i][j] == k) {
                count++
            }
        }
    }
    println(count)
}