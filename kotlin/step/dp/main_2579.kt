import kotlin.math.max

fun main() {
    val num = readLine()!!.toInt()
    val dp = mutableListOf(0)

    var prev = readLine()!!.toInt()
    dp.add(prev)

    var now = 0
    if (num > 1) {
        now = readLine()!!.toInt()
        dp.add(prev + now)
        prev = now
    }

    for (i in 3..num){
        now = readLine()!!.toInt()
        dp.add(max(dp[i - 3] + prev + now, dp[i - 2] + now))
        prev = now
    }
    println(dp[num])
}