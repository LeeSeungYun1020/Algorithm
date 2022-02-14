fun main() {
    val n = readLine()!!.toLong()
    when (n) {
        0L -> print(0)
        1L -> print(1)
        else -> print(arrayOf(intArrayOf(1, 1), intArrayOf(1, 0)).pow(n - 1)[0][0])
    }
}

operator fun Array<IntArray>.times(other: Array<IntArray>): Array<IntArray> {
    val result = Array<IntArray> (this.size) { IntArray(other[0].size) }
    for (i in this.indices) {
        for (j in this[0].indices) {
            val tem = this[i][j].toLong()
            for (k in other[0].indices){
                result[i][k] = ((result[i][k] + (tem * other[j][k] % 1000000007)) % 1000000007).toInt()
            }
        }
    }
    return result
}

fun Array<IntArray>.pow(n: Long): Array<IntArray> {
    if (n == 1L)
        return this
    val tem = this.pow(n/2)
    return if (n % 2 == 0L) {
        tem * tem
    } else {
        tem * tem * this
    }
}