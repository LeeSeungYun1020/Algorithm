import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val array = Array(n) { readLine()!!.split(' ').map { it.toInt() }.toIntArray() }
    for (i in 1 until n) {
        array[i][0] += array[i - 1][0]
        for (j in 1 until i) {
            array[i][j] += max(array[i - 1][j - 1], array[i - 1][j])
        }
        array[i][i] += array[i - 1][i - 1]
    }
    println(array[n - 1].maxOrNull())
}