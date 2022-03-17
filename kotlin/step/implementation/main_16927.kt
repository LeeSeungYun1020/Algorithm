import kotlin.math.min

fun main() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    val num = List(n) { readln().split(" ").map { it.toInt() }.toMutableList() }

    fun rotate(level: Int) {
        val xStart = level
        val yStart = level
        val xEnd = n - 1 - level
        val yEnd = m - 1 - level

        val tem = num[xStart][yStart]
        for (k in yStart until yEnd) {
            num[xStart][k] = num[xStart][k+1]
        }
        for (k in xStart until xEnd) {
            num[k][yEnd] = num[k+1][yEnd]
        }
        for (k in yEnd downTo yStart + 1) {
            num[xEnd][k] = num[xEnd][k - 1]

        }
        for (k in xEnd downTo xStart + 1) {
            num[k][yStart] = num[k-1][yStart]
        }
        num[xStart+1][yStart] = tem
    }

    val maxLevel = min(n, m) / 2
    for (level in 0 until maxLevel) {
        val d = r % (2 * (n + m - 4 * level) - 4)
        for (i in 1..d) {
            rotate(level)
        }
    }
    println(num.joinToString("\n") { it.joinToString(" ") })
}