fun main() {
    val (n, b) = readLine()!!.split(' ').map { it.toLong() }
    val arr = Array<IntArray> (n.toInt()) { readLine()!!.split(' ').map { it.toInt() }.toIntArray() }
    arr.pow(b).print()
}

operator fun Array<IntArray>.times(other: Array<IntArray>): Array<IntArray> {
    val result = Array<IntArray> (this.size) { IntArray(other[0].size) }
    for (i in this.indices) {
        for (j in this[0].indices) {
            val tem = this[i][j]
            for (k in other[0].indices){
                result[i][k] = (result[i][k] + tem * other[j][k]) % 1000
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

fun Array<IntArray>.print() {
    for (i in this.indices) {
        for (j in this[i].indices)
            print("${this[i][j] % 1000} ")
        println()
    }
}