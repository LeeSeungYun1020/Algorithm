import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    val num = readLine()!!.toInt()
    val dp = MutableList(num + 1) { it }
    for (i in 3..num){
        val s = sqrt(i.toDouble()).toInt()
        if (s * s == i)
            dp[i] = 1
        else
        for (j in 1..s)
            dp[i] = min(dp[i], dp[i - j * j] + 1)
    }
    println(dp[num]);
}