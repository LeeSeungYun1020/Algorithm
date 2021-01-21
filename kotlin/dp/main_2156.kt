fun main() {
    val num = readLine()!!.toInt()

    val dp = mutableListOf(0, 0, 0)
    var prev = 0
    var now = 0
    for (i in 3..num + 2){
        now = readLine()!!.toInt()
        dp.add(maxOf(dp[i - 1], dp[i - 2] + now, dp[i - 3] + prev + now))
        prev = now
    }
    println(dp[num + 2])
}