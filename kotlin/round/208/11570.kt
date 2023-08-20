import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

fun main() {
    val size = readln().toInt()
    val heights = readln().split(" ").map { it.toInt() }
    val dp = List(size + 1) { MutableList(size + 1) { Int.MAX_VALUE } }

    dp[0][0] = 0
    dp[0][1] = 0
    dp[1][0] = 0
    for (i in 0 until size) {
        for (j in 0 until size) {
            if (i == j) continue
            val next = max(i, j) + 1
            dp[i][next] =
                min(dp[i][next], dp[i][j] + if (j == 0) 0 else (heights[next - 1] - heights[j - 1]).absoluteValue)
            dp[next][j] =
                min(dp[next][j], dp[i][j] + if (i == 0) 0 else (heights[next - 1] - heights[i - 1]).absoluteValue)
        }
    }
    println(min(dp.minOf { it.last() }, dp.last().minOf { it }))
}