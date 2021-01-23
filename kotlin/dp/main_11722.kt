import kotlin.math.max

fun main() {
    val num = readLine()!!.toInt()
    val list = readLine()!!.split(" ").map{ it.toInt() }
    val dp = MutableList(num) { 1 }

    for (i in (num - 2).downTo(0)){
        for (k in (num - 1).downTo(i)){
            if (list[i] > list[k])
                dp[i] = max(dp[i], dp[k] + 1)
        }
    }
    println(dp.maxOrNull())
}