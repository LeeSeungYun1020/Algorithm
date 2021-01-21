fun main() {
    val count = readLine()!!.toInt()
    val dp = mutableListOf<Long>(1, 1, 1)
    var lim = 3
    for (c in 1..count){
        val num = readLine()!!.toInt()
        for (i in lim until num)
            dp.add(dp[i - 3] + dp[i - 2])
        if (lim < num) lim = num
        println(dp[num - 1])
    }
}