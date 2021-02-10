lateinit var array: Array<IntArray>
var n = 0

fun main() {
    n = readLine()!!.toInt()
    array = Array(n) { readLine()!!.map { it - '0' }.toIntArray() }
    print(toQuad(n, 0 to 0))
}

fun toQuad(length: Int, start: Pair<Int, Int>): String {
    val standard = array[start.first][start.second]
    if (length == 1){
        return standard.toString()
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
    return if (pass) {
        standard.toString()
    } else {
        val half = length / 2
        "(${toQuad(half, start)}${toQuad(half, start.first to start.second + half)}${toQuad(half, start.first + half to start.second)}${toQuad(half, start.first + half to start.second + half)})"
    }
}