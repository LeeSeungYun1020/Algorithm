fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val input = readln().split(" ").map { it.toInt() }

    val selected = MutableList(n) { false }
    var sum = 0
    var ans = 0
    fun dfs(prev: Int, level: Int) {
        if (level > 0 && sum == s) {
            ans++
        }
        if (level == n) {
            return
        }
        for (i in prev + 1 until n) {
            if (!selected[i]) {
                selected[i] = true
                sum += input[i]
                dfs(i, level + 1)
                sum -= input[i]
                selected[i] = false
            }
        }
    }
    dfs(-1, 0)
    println(ans)
}