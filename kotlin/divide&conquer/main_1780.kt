lateinit var array: Array<IntArray>
var mCount = 0
var zCount = 0
var pCount = 0

fun main() {
    val n = readLine()!!.toInt()
    array = Array(n) { readLine()!!.split(' ').map { it.toInt() }.toIntArray() }
    cut(n, 0 to 0)
    println(mCount)
    println(zCount)
    println(pCount)
}

fun cut(length: Int, start: Pair<Int, Int>) {
    val standard = array[start.first][start.second]
    if (length == 1){
        when (standard) {
            -1 -> mCount++
            0 -> zCount++
            1 -> pCount++
        }
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
        when (standard) {
            -1 -> mCount++
            0 -> zCount++
            1 -> pCount++
        }
    } else {
        val len = length / 3
        cut(len, start)
        cut(len, start.first to start.second + len)
        cut(len, start.first to start.second + len * 2)
        cut(len, start.first + len to start.second)
        cut(len, start.first + len * 2 to start.second)
        cut(len, start.first + len to start.second + len)
        cut(len, start.first + len * 2 to start.second + len)
        cut(len, start.first + len to start.second + len * 2)
        cut(len, start.first + len * 2 to start.second + len * 2)
    }
}