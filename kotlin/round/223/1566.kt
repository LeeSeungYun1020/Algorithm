import kotlin.math.min

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val board = List(n) { readln().split(" ").map { it.toInt() }.toMutableList() }

    val row = MutableList(n) { 0 }
    val column = MutableList(m) { 0 }
    for (i in 0 until n) {
        for (j in 0 until m) {
            row[i] += board[i][j]
            column[j] += board[i][j]
        }
    }

    var answer = m + n + 1

    fun check(change: Int) {
        // - 항목 모두 바꾸고 조건 만족하는지 확인
        val changed = mutableSetOf<Int>()
        var count = change
        var flag = true
        for (i in 0 until m) {
            if (column[i] < 0) {
                changeColumn(board, row, column, i)
                changed.add(i)
                count++
                if (count >= answer) {
                    flag = false
                    break
                }
            }
        }

        if (flag && row.all { it > 0 } && column.all { it > 0 }) {
            answer = min(answer, count)
        }
        for (i in changed) {
            restoreColumn(board, row, column, i)
        }
    }

    // row 선택
    fun dfsRow(change: Int, rowIndex: Int) {
        if (change >= answer) return

        // row 선택 완료
        if (rowIndex == n) {
            check(change)
            return
        }

        dfsRow(change, rowIndex + 1)

        changeRow(board, row, column, rowIndex)
        dfsRow(change + 1, rowIndex + 1)
        restoreRow(board, row, column, rowIndex)
    }

    dfsRow(0, 0)

    if (answer > m + n) {
        println(-1)
    } else {
        println(answer)
    }
}

fun changeRow(board: List<MutableList<Int>>, row: MutableList<Int>, column: MutableList<Int>, index: Int) {
    row[index] = -row[index]
    for (i in column.indices) {
        board[index][i] = -board[index][i]
        column[i] += (board[index][i] * 2)
    }
}

fun restoreRow(board: List<MutableList<Int>>, row: MutableList<Int>, column: MutableList<Int>, index: Int) {
    row[index] = -row[index]
    for (i in column.indices) {
        board[index][i] = -board[index][i]
        column[i] += (board[index][i] * 2)
    }
}

fun changeColumn(board: List<MutableList<Int>>, row: MutableList<Int>, column: MutableList<Int>, index: Int) {
    column[index] = -column[index]
    for (i in row.indices) {
        board[i][index] = -board[i][index]
        row[i] += (board[i][index] * 2)
    }
}

fun restoreColumn(board: List<MutableList<Int>>, row: MutableList<Int>, column: MutableList<Int>, index: Int) {
    column[index] = -column[index]
    for (i in row.indices) {
        board[i][index] = -board[i][index]
        row[i] += (board[i][index] * 2)
    }
}