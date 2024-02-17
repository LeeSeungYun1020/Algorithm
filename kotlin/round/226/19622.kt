import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val list = List(n) {
        readln().split(" ").last().toLong()
    }
    // O, X 순
    val dp = List(n) { mutableListOf(0L, 0L) }
    dp[0][0] = list[0]
    for (i in 1 until n) {
        dp[i][0] = dp[i - 1][1] + list[i]
        dp[i][1] = max(dp[i - 1][0], dp[i - 1][1])
    }
    println(dp.last().maxOf { it })
}