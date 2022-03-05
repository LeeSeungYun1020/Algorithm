import kotlin.math.max

class Method(var one: Int, var two: Int, var three: Int){
    fun set(one: Int, two: Int, three: Int) {
        this.one = one % 1_000_000_009
        this.two = two % 1_000_000_009
        this.three = three % 1_000_000_009
    }

    fun sum() = ((one.toLong() + two) % 1_000_000_009 + three) % 1_000_000_009

    fun sumOfNotStartWith(n: Int) = when(n) {
        1 -> (two.toLong() + three) % 1_000_000_009
        2 -> (one.toLong() + three) % 1_000_000_009
        3 -> (one.toLong() + two) % 1_000_000_009
        else -> 0
    }.toInt()

    override fun toString(): String {
        return "$one $two $three"
    }
}

fun main() {
    val n = readln().toInt()
    val num = List(n) { readln().toInt() }
    val mx = num.maxOf { it }
    val dp = List(max(4, mx + 1)) { Method(0, 0, 0) }
    dp[1].one = 1
    dp[2].two = 1
    dp[3].set(1, 1, 1)
    for (i in 4..mx){
        dp[i].set(dp[i-1].sumOfNotStartWith(1), dp[i-2].sumOfNotStartWith(2), dp[i-3].sumOfNotStartWith(3))
    }

    for (t in num)
        println(dp[t].sum())
}