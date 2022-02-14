lateinit var array: Array<IntArray>
var zeroCount = 0
var oneCount = 0

fun main() {
    val n = readLine()!!.toInt()
    array = Array(n) { readLine()!!.split(' ').map { it.toInt() }.toIntArray() }
    cut(n, 0 to 0)
    println(zeroCount)
    print(oneCount)
}

fun cut(length: Int, start: Pair<Int, Int>) {
    val standard = array[start.first][start.second]
    if (length == 1){
        if (standard == 0)
            zeroCount++
        else
            oneCount++
        return
    }

    var pass = true
    for (i in start.first until start.first + length) {
        for (j in start.second until start.second + length) {
            if (array[i][j] != standard) {
                pass = false
            }
        }
        if (!pass)
            break
    }
    if (pass) {
        if (standard == 0)
            zeroCount++
        else
            oneCount++
    } else {
        val half = length / 2
        cut(half, start)
        cut(half, start.first + half to start.second)
        cut(half, start.first to start.second + half)
        cut(half, start.first + half to start.second + half)
    }
}