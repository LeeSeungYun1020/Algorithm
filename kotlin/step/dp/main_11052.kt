import kotlin.math.max

fun main() {
    val num = readLine()!!.toInt()
    val price = readLine()!!.split(" ").map { it.toInt() }
    val dp = mutableListOf(0)

    for(i in 1..num) {
        dp.add(i, price[i - 1])
        for (j in 1..(i/2)) {
            dp[i] = max(dp[i], dp[j] + dp[i - j])
        }
    }
    println(dp.last())
}