fun main() {
    val (num, e, w, s, n) = readln().split(" ").map { it.toInt() }
    val (ep, wp, sp, np) = listOf(e, w, s, n).map { it.toDouble() / 100 }
    val visited = List(num * 2 + 1) { MutableList(num * 2 + 1) { false } }
    var ans = 0.0
    fun dfs(x: Int, y: Int, level: Int, p: Double) {
        if (level == num) {
            ans += p
            return
        }
        if (p > 0) {
            if (!visited[x + 1][y]) {
                visited[x + 1][y] = true
                dfs(x + 1, y, level + 1, p * np)
                visited[x + 1][y] = false
            }
            if (!visited[x - 1][y]) {
                visited[x - 1][y] = true
                dfs(x - 1, y, level + 1, p * sp)
                visited[x - 1][y] = false
            }
            if (!visited[x][y + 1]) {
                visited[x][y + 1] = true
                dfs(x, y + 1, level + 1, p * ep)
                visited[x][y + 1] = false
            }
            if (!visited[x][y - 1]) {
                visited[x][y - 1] = true
                dfs(x, y - 1, level + 1, p * wp)
                visited[x][y - 1] = false
            }
        }
    }
    visited[num][num] = true
    dfs(num, num, 0, 1.0)
    println("%.12f".format(ans))
}