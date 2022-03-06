fun main() {
    val n = readln().toInt()
    val num = readln().split(" ").map { it.toInt() }
    val dp = MutableList(n) { 0 }
    dp[0] = num[0]
    for (i in 1 until n) {
        for (j in i-1 downTo 0) {
            if (num[i] > num[j] && dp[i] < dp[j]) {
                dp[i] = dp[j]
            }
        }
        dp[i] += num[i]
    }
    println(dp.maxOf { it })
}