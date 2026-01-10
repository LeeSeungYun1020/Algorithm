import kotlin.math.min

const val MAX = 1_000_000

fun main() {
    readln()
    val hurdle = readln().split(" ").map { it.toInt() }
    var current = 0

    val dp = MutableList(hurdle.last()) { MAX }
    dp[0] = 0
    if (hurdle.first() != 1) {
        dp[1] = 1
    } else {
        current++
    }

    for (i in 2..dp.lastIndex) {
        if (hurdle[current] > i) {
            dp[i] = min(dp[i - 2] + 1, dp[i - 1] + 1)
        } else if (hurdle[current] == i) {
            current++
            continue
        }
    }
    if (dp.last() >= MAX) println(-1)
    else println(dp.last() + 1)
}