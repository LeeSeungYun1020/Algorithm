lateinit var array: Array<Int>
lateinit var visited: Array<Boolean>

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    array = Array(m) { 0 }
    visited = Array(n) { false }
    dfs(0, 0, n, m)
}

fun dfs(idx: Int, depth: Int, n: Int, m: Int) {
    if (idx > n)
        return
    if (depth == m) {
        array.forEach {
            print("$it ")
        }
        println()
    } else {
        for (i in idx until n) {
            if (!visited[i]) {
                array[depth] = i + 1
                visited[i] = true
                dfs(i + 1, depth + 1, n, m)
                visited[i] = false
            }
        }
    }
}