import kotlin.math.max

fun main() {
    val num = readLine()!!.toInt()
    val dp = mutableListOf(0)
    var m = -1000
    readLine()!!.split(' ').map { it.toInt() }.forEachIndexed { index, value ->
        dp.add(max(value, dp[index] + value))
        m = max(m, dp.last())
    }
    println(m)
}