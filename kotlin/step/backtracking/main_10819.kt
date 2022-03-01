import kotlin.math.absoluteValue
import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val list = readLine()!!.split(" ").map { it.toInt() }
    val index = MutableList(n) { 0 }
    val visited = MutableList(n) { false }
    var ans = 0
    fun dfs(level: Int) {
        if (level == n) {
            ans = max(ans, index.zipWithNext { a: Int, b: Int -> (list[a] - list[b]).absoluteValue }.sum())
            return
        }
        for (i in 0 until n) {
            if (!visited[i]) {
                visited[i] = true
                index[level] = i
                dfs(level + 1)
                visited[i] = false
            }
        }
    }
    dfs(0)
    println(ans)
}