import kotlin.math.min

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val board = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        board[i] = readLine()!!.mapIndexed { index, c ->
            val odd = (i + index) % 2
            (odd == 0 && c == 'B') || (odd == 1 && c == 'W')
        }.toBooleanArray()
    }

    var ans = 64
    for (i in 0..n - 8) {
        for (j in 0..m - 8) {
            var sum = 0
            for (k in i..i + 7) {
                for (l in j..j + 7) {
                    if (board[k][l])
                        sum++
                }
            }
            sum = min(sum, 64 - sum)
            ans = min(ans, sum)
        }
    }
    println(ans)
}