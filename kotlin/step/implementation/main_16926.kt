import kotlin.math.min
fun main() {
    val (n, m, r) = readLine()!!.split(" ").map { it.toInt() }
    val board = List(n) { readLine()!!.split(" ").map { it.toInt() }.toMutableList() }

    // 회전
    for (c in 1..r) {
        // 단계
        for (level in 0 until min(n,m)/2){
            // 0단계
            // 0, 0 -> n-1, 0
            // n-1, 0 -> n-1, m-1
            // n-1 , m-1 -> 0, m-1
            // 0, m-1 -> 0,0
            // 1단계
            // 1, 1 -> n-2, 1
            // n -2, 1 -> n-2, m-2
            // n-2,m-2 -> 1, m-2
            // 1, m-2 -> 1, 1
            // ...
            val ul = board[level][level]
            val ur = board[level][m-1-level]
            val dl = board[n-1-level][level]
            val dr = board[n-1-level][m-1-level]
            for (i in level until m-1-level)
                board[level][i] = board[level][i+1]
            for (j in level until n-1-level)
                board[j][m-1-level] = board[j+1][m-1-level]
            for (i in m-1-level downTo level + 1)
                board[n-1-level][i] = board[n-1-level][i - 1]
            for (j in n-1-level downTo level + 1)
                board[j][level] = board[j-1][level]
            board[level+1][level] = ul
        }
    }
    for (b in board) println(b.joinToString(" "))
}