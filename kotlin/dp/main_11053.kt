import kotlin.math.max

fun main() {
    val num = readLine()!!.toInt()
    val list = readLine()!!.split(" ").map{ it.toInt() }
    val dp = mutableListOf(1)

    for (i in 1 until num){
        dp.add(i, 1)
        for (j in 0 until i) {
            if (list[i] > list[j])
                dp[i] = max(dp[i], dp[j] + 1)
        }
    }
    println(dp.maxOrNull())
}