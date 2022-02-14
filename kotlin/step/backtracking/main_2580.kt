import kotlin.system.exitProcess

val board = Array<IntArray>(9) { IntArray(9) }

fun main() {
    for (i in 0..8) {
        board[i] = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    }
    fillBlank(0)
}

fun fillBlank(index: Int) {
    if (index == 81) {
        for (i in 0..8) {
            for (j in 0..8)
                print("${board[i][j]} ")
            println()
        }
        exitProcess(0)
    } else {
        val x = index / 9
        val y = index % 9
        if (board[x][y] != 0) {
            fillBlank(index + 1)
        } else {
            for (i in 1..9) {
                if (checkBlank(x, y, i)){
                    board[x][y] = i
                    fillBlank(index + 1)
                    board[x][y] = 0
                }
            }
        }
    }
}

fun checkBlank(x: Int, y: Int, value: Int): Boolean {
    for (i in 0..8) {
        if (board[x][i] == value || board[i][y] == value)
            return false
    }
    val idx = x / 3 * 3
    val idy = y / 3 * 3
    for (i in idx..idx + 2) {
        for (j in idy..idy + 2) {
            if (board[i][j] == value)
                return false
        }
    }
    return true
}