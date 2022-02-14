import kotlin.math.min

fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val dp = Array(n + 1) { size -> IntArray(size / 2 + 1) { 1 } }
    for (i in 2..n){
        for (j in 1..(i / 2)){
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][min(j, i - j - 1)]) % 10007
        }
    }
    println(dp[n][min(k, n-k)])
}