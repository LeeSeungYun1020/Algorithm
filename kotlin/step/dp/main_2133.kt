fun main() {
    val num = readLine()!!.toInt()
    if (num % 2 == 1) {
        println(0)
        return
    }

    val dp = mutableListOf(1, 3)
    for (i in 2..num/2){
        dp.add(i, dp[i - 1])
        for (j in 0 until i)
            dp[i] += 2 * dp[j]
    }
    println(dp.last())
}