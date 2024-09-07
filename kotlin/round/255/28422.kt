import kotlin.math.max

fun main() {
    val numberOfCards = readln().toInt()
    val cards = readln().split(" ").map { it.toInt() }
    val dp = MutableList(numberOfCards + 1) { 0 }

    fun calc(last: Int, number: Int): Int {
        return if (last - number < 0) 0
        else cards.slice(last - number until last).reduce(Int::xor).toString(radix = 2).count { it == '1' }
    }

    fun select(current: Int): Int {
        return if (current < 2) 0
        else if (current == 2) calc(2, 2)
        else if (current == 3) calc(3, 3)
        else if (current == 4) dp[2] + calc(4, 2)
        else max(dp[current - 3] + calc(current, 3), dp[current - 2] + calc(current, 2))
    }

    for (i in 2..dp.lastIndex) {
        dp[i] = select(i)
    }
    println(dp.last())
}