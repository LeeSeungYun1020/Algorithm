fun main() {
    val n = readln().toInt()
    var mx = 3
    val number = List(n) {
        val i = readln().toInt()
        if (i > mx)
            mx = i
        i
    }
    val dp = MutableList(mx + 1) { 0 }
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for (i in 4..mx) {
        dp[i] = (((dp[i-1] + dp[i-2]) % 1_000_000_009) + dp[i-3]) % 1_000_000_009
    }
    for (i in number) {
        println(dp[i])
    }
}