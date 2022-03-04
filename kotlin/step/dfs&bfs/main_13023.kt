fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val friend = List(n) { mutableListOf<Int>() }
    for (t in 1..m) {
        val (i, j) = readln().split(" ").map { it.toInt() }
        friend[i].add(j)
        friend[j].add(i)
    }

    val visited = MutableList(n) { false }
    var find = false
    fun dfs(level: Int, start: Int) {
        if (find) return
        if (level == 4) {
            find = true
            println(1)
            return
        }

        for (f in friend[start]) {
            if (!visited[f]) {
                visited[f] = true
                dfs(level + 1, f)
                visited[f] = false
            }
        }
    }

    for (i in 0 until n) {
        visited[i] = true
        dfs(0, i)
        visited[i] = false
        if (find) break
    }

    if (!find)
        println(0)
}