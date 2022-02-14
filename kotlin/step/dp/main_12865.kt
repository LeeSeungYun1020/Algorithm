import kotlin.math.max

fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val array = Array(n + 1) { IntArray(k + 1) }
    for (i in 1..n) {
        val (weight, value) = readLine()!!.split(' ').map { it.toInt() }
        for (j in 1..k) {
            array[i][j] = when {
                j < weight -> array[i - 1][j]
                else -> max(value + array[i - 1][j - weight], array[i - 1][j])
            }
        }
    }
    println(array[n][k])
}