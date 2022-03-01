import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val path = List(n) { readLine()!!.split(" ").map { it.toInt() } }
    val visited = MutableList(n) { false }
    var ans = Int.MAX_VALUE
    var sum = 0
    var start = 0
    fun dfs(prev: Int, level: Int) {
        if (sum >= ans) return
        if (level == n - 1) {
            if (path[prev][start] > 0)
                ans = min(ans, sum + path[prev][start])
            return
        }
        for (i in 0 until n) {
            if (!visited[i] && path[prev][i] > 0) {
                visited[i] = true
                sum += path[prev][i]
                dfs(i, level + 1)
                sum -= path[prev][i]
                visited[i] = false
            }
        }
    }
    for (i in 0 until n) {
        start = i
        visited[start] = true
        dfs(start, 0)
        visited[start] = false
    }
    println(ans)
}