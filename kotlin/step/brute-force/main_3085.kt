import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val candy = List(n) {
        readLine()!!.map {
            when (it) {
                'C' -> 0
                'P' -> 1
                'Z' -> 2
                else -> 3
            }
        }.toMutableList()
    }

    fun count(): Int {
        var row = 1
        var col = 1
        var rowCount = 1
        var colCount = 1
        for (i in 0 until n) {
            for (j in 0 until n - 1) {
                if (candy[i][j] == candy[i][j + 1]) {
                    rowCount++
                } else {
                    row = max(row, rowCount)
                    rowCount = 1
                }
                if (candy[j][i] == candy[j + 1][i]) {
                    colCount++
                } else {
                    col = max(col, colCount)
                    colCount = 1
                }
            }
            row = max(row, rowCount)
            rowCount = 1
            col = max(col, colCount)
            colCount = 1
        }
        return max(row, col)
    }

    fun swap(pos1: Pair<Int, Int>, pos2: Pair<Int, Int>) {
        val tem = candy[pos1.first][pos1.second]
        candy[pos1.first][pos1.second] = candy[pos2.first][pos2.second]
        candy[pos2.first][pos2.second] = tem
    }

    var mx = 0

    fun simulate(pos1: Pair<Int, Int>, pos2: Pair<Int, Int>) {
        if (candy[pos1.first][pos1.second] != candy[pos2.first][pos2.second]) {
            swap(pos1, pos2)
            mx = max(mx, count())
            swap(pos1, pos2)
        }
    }



    for (i in 0 until n) {
        for (j in 0 until n) {
            if (j + 1 < n)
                simulate(i to j, i to j+1)
            if (i + 1 < n)
                simulate(i to j, i+1 to j)
            if (mx == n) {
                println(n)
                return
            }
        }
    }

    println(mx)

}