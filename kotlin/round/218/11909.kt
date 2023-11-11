import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val board = List(n) { readln().split(" ").map { it.toInt() } }
    val answer = List(n) { MutableList(n) { 0 } }
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (i == 0 && j == 0)
                continue

            val now = board[i][j]
            when {
                i == 0 -> {
                    answer[i][j] = price(board[i][j - 1], answer[i][j - 1], now)
                }
                j == 0 -> {
                    answer[i][j] = price(board[i - 1][j], answer[i - 1][j], now)
                }
                else -> {
                    answer[i][j] = price(
                        left = board[i][j - 1],
                        top = board[i - 1][j],
                        leftPrice = answer[i][j - 1],
                        topPrice = answer[i - 1][j],
                        now = now
                    )
                }
            }
        }
    }
    println(answer.last().last())
}

fun price(target: Int, price: Int, now: Int): Int {
    return when {
        now >= target -> now - target + 1 + price
        else -> price
    }
}

fun price(left: Int, top: Int, leftPrice: Int, topPrice: Int, now: Int): Int {
    return min(price(left, leftPrice, now), price(top, topPrice, now))
}