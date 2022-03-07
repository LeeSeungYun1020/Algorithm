import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val num = readln().split(" ").map { it.toInt() }
    val dp = List(n) { MutableList(2) { 0 } }
    var ans = num[0]
    dp[0][0] = num[0]
    dp[0][1] = num[0]
    for (i in 1 until n) {
        dp[i][0] = max(dp[i-1][0] + num[i], num[i])
        dp[i][1] = max(dp[i-1][0], dp[i-1][1] + num[i])
        ans = max(ans, max(dp[i][0], dp[i][1]))
    }
    println(ans)
}