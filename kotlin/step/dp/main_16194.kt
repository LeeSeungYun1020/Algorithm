import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val price = readln().split(" ").map { it.toInt() }
    val dp = MutableList(n + 1) { 0 }
    for (i in 1 .. n) {
        dp[i] = price[i - 1]
        for (j in 1..i/2) {
            dp[i] = min(dp[i], dp[j] + dp[i - j])
        }
    }
    println(dp.last())
}