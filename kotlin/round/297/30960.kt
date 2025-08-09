import kotlin.math.min

fun main() {
    readln()
    val people = readln().split(" ").map { it.toInt() }.sorted()

    val dp = MutableList(people.size + 1) { 1_000_000_001 }
    dp[0] = 0
    dp[2] = people[1] - people[0]
    for (i in 3..dp.lastIndex) {
        if (i % 2 == 0) {
            dp[i] = dp[i - 2] + people[i - 1] - people[i - 2]
        } else {
            dp[i] = min(dp[i - 3] + people[i - 1] - people[i - 3], dp[i - 2] + people[i - 1] - people[i - 2])
        }
    }
    println(dp.last())
}