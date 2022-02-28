import kotlin.math.max

fun main() {
    val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
    val board = List(n) { readLine()!!.split(" ").map { it.toInt() } }
    val visited = List(n) { MutableList(m) { false} }
    var ans = -40000
    var sum = 0
    fun checkValid(x: Int, y: Int): Boolean = (visited[x][y] || (x-1 >= 0 && visited[x-1][y]) || (y-1 >= 0 && visited[x][y-1]) || (y + 1 < m && visited[x][y+1]) || (x+1<n && visited[x+1][y]))
    fun dfs(level: Int) {
        if (level == k) {
            ans = max(ans, sum)
            return
        }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (!checkValid(i, j)) {
                    visited[i][j] = true
                    sum += board[i][j]
                    dfs(level + 1)
                    sum -= board[i][j]
                    visited[i][j] = false
                }
            }
        }
    }

    dfs(0)
    println(ans)
}