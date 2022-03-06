import kotlin.math.max

enum class Direction {
    WIDTH, HEIGHT
}

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val paper = List(n) { readln().map { it.digitToInt() } }
    val selected = List(n) { MutableList(m) { Direction.WIDTH } }
    var ans = 0

    fun calcSum(): Int {
        var sum = 0
        for (i in 0 until n) {
            var subSum = 0
            for (j in 0 until m) {
                if (selected[i][j] == Direction.WIDTH) {
                    subSum = subSum * 10 + paper[i][j]
                } else {
                    sum += subSum
                    subSum = 0
                }
            }
            sum += subSum
        }
        for (j in 0 until m) {
            var subSum = 0
            for (i in 0 until n) {
                if (selected[i][j] == Direction.HEIGHT) {
                    subSum = subSum * 10 + paper[i][j]
                } else {
                    sum += subSum
                    subSum = 0
                }
            }
            sum += subSum
        }
        return sum
    }

    fun dfs(pos: Pair<Int, Int>) {
        if (pos.first == n) {
            ans = max(ans, calcSum())
            return
        }
        val next = if (pos.second + 1 == m) pos.first + 1 to 0 else pos.first to pos.second + 1
        selected[pos.first][pos.second] = Direction.WIDTH
        dfs(next)
        selected[pos.first][pos.second] = Direction.HEIGHT
        dfs(next)
    }
    dfs(0 to 0)
    println(ans)
}