import kotlin.math.max

fun main() {
    readln()
    val numbers = readln().trim().split(" ").map { it.toInt() }
    val dp = MutableList(numbers.size) { 1 }
    var ans = 1
    for (i in numbers.indices) {
        for (j in 0 until i) {
            if (numbers[i] > numbers[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
        ans = max(ans, dp[i])
    }
    println(ans)
}