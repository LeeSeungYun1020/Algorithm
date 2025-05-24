fun main() {
    repeat(readln().toInt()) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val board = List(n) { readln().split(" ").map { it.toInt() } }
        fun check(i: Int, j: Int, target: Int): Boolean {
            for (x in i - 1..i + 1) {
                for (y in j - 1..j + 1) {
                    if (x == i && y == j) continue
                    if (x in 0 until n && y in 0 until m && board[x][y] == target) return true
                }
            }
            return false
        }

        val checker = mutableMapOf<Int, Boolean>()
        checker[-1] = false
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] in checker) continue
                if (check(i, j, board[i][j])) checker[board[i][j]] = true
            }
        }
        println(checker.size - 1)
    }
}