fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val arrA = Array<IntArray> (n) { readLine()!!.split(' ').map { it.toInt() }.toIntArray() }
    val o = readLine()!!.split(' ')[1].toInt()
    val arrB = Array<IntArray> (m) { readLine()!!.split(' ').map { it.toInt() }.toIntArray() }
    val result = Array<IntArray> (n) { IntArray(o) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            val tem = arrA[i][j]
            for (k in 0 until o){
                result[i][k] += tem * arrB[j][k]
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until o)
            print("${result[i][j]} ")
        println()
    }
}