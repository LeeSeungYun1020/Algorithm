fun main() {
    val (size, range) = readln().split(' ').map { it.toInt() }
    val land = List(size) { readln().split(' ').map { -it.toLong() } }

    val sum = List(size) { MutableList(size) { 0L } }
    fun calcSum(topLeft: Pair<Int, Int>, bottomRight: Pair<Int, Int>): Long {
        return sum[bottomRight.first][bottomRight.second] -
                (sum.getOrNull(topLeft.first - 1)?.get(bottomRight.second) ?: 0L) -
                sum[bottomRight.first].getOrElse(topLeft.second - 1) { 0 } +
                (sum.getOrNull(topLeft.first - 1)?.getOrNull(topLeft.second - 1) ?: 0)
    }

    val result = List(size) { MutableList(size) { 0L } }
    val margin = range / 2
    for (i in 0..size - range) {
        for (j in 0..size - range) {
            sum[i][j] = (sum.getOrNull(i - 1)?.get(j) ?: 0) +
                    sum[i].getOrElse(j - 1) { 0 } -
                    (sum.getOrNull(i - 1)?.getOrNull(j - 1) ?: 0)
            val damage = calcSum(i - range + 1 to j - range + 1, i to j)
            val need = land[i][j] - damage
            if (need > 0) {
                sum[i][j] += need
                result[i + margin][j + margin] = need
            }
        }
    }

    println(result.joinToString(separator = "\n") { it.joinToString(separator = " ") })
}