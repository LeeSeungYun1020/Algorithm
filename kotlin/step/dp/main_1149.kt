import kotlin.math.min

fun main() {
    val house = readLine()!!.toInt()
    var dp = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    for (i in 2..house) {
        val (r, g, b) = readLine()!!.split(' ').map { it.toInt() }
        val dpR = min(dp[1], dp[2]) + r
        val dpG = min(dp[0], dp[2]) + g
        val dpB = min(dp[0], dp[1]) + b
        dp[0] = dpR
        dp[1] = dpG
        dp[2] = dpB
    }
    println(dp.minOrNull())
}