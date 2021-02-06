lateinit var array: Array<Int>
lateinit var visited: Array<Boolean>

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    array = Array(m) { 0 }
    visited = Array(n) { false }
    dfs(0, n, m)
}

fun dfs(depth: Int, n: Int, m: Int) {
    if (depth == m) {
        array.forEach {
            print("$it ")
        }
        println()
    } else {
        for (i in 0 until n) {
            if (!visited[i]) {
                array[depth] = i + 1
                visited[i] = true
                dfs(depth + 1, n, m)
                visited[i] = false
            }
        }
    }
}