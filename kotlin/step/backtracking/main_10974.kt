fun main() {
    val n = readLine()!!.toInt()
    val list = MutableList(n) { 0 }
    val visited = MutableList(n) { false }
    fun dfs(level: Int) {
        if (level == n) {
            println(list.joinToString(" "))
            return
        }
        for (i in 0 until n) {
            if (!visited[i]) {
                visited[i] = true
                list[level] = i + 1
                dfs(level + 1)
                visited[i] = false
            }
        }
    }
    dfs(0)
}