lateinit var array: Array<Int>

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    array = Array(m) { 0 }
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
            array[depth] = i + 1
            dfs(depth + 1, n, m)
        }
    }
}