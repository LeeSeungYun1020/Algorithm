import kotlin.math.min

fun main() {
    val dp = Array(31) { size -> IntArray(size / 2 + 1) { 1 } }
    for (i in 2..30){
        for (j in 1..(i / 2)){
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][min(j, i - j - 1)])
        }
    }

    val count = readLine()!!.toInt()
    for (i in 1..count){
        val (k, n) = readLine()!!.split(' ').map { it.toInt() }
        println(dp[n][min(k, n-k)])
    }
}