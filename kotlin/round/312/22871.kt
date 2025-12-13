import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

fun main() {
    readln()
    val rocks = readln().split(" ").map { it.toLong() }

    val dp = MutableList(rocks.size) { Long.MAX_VALUE }
    dp[0] = 0
    for (j in 1..rocks.lastIndex) {
        for (i in j - 1 downTo 0) {
            val cost = max(dp[i], (j - i) * (1 + (rocks[i] - rocks[j]).absoluteValue))
            dp[j] = min(dp[j], cost)
        }
    }
    println(dp.last())
}