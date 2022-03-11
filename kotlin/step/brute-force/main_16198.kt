import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val weight = readln().split(' ').map { it.toInt() }

    val visited = MutableList(n) { false }
    var ans = 0
    fun dfs(level: Int, sum: Int) {
        if (level == n - 2) {
            ans = max(ans, sum)
        }
        for (i in 1 until n - 1) {
            if (!visited[i]) {
                visited[i] = true
                var left = 0
                for (j in i - 1 downTo 0) {
                    if (!visited[j]) {
                        left = weight[j]
                        break
                    }
                }
                var right = 0
                for (k in i + 1 until n) {
                    if (!visited[k]) {
                        right = weight[k]
                        break
                    }
                }
                dfs(level + 1, sum + left * right)
                visited[i] = false
            }
        }
    }
    dfs(0, 0)
    println(ans)
}