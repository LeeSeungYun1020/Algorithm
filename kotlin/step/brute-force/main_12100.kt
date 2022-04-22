import kotlin.math.max

fun List<List<Int>>.moveLeft(mx: Int): List<List<Int>> {
    val newBoard = this.map { it.toMutableList() }
    for (height in 0 until mx) {
        for (i in 0 until mx) {
            if (newBoard[height][i] == 0) {
                for (j in i + 1 until mx) {
                    if (newBoard[height][j] != 0) {
                        newBoard[height][i] = newBoard[height][j]
                        newBoard[height][j] = 0
                        break
                    }
                }
            }
            for (j in i + 1 until mx) {
                if (newBoard[height][j] == 0)
                    continue
                else if (newBoard[height][i] == newBoard[height][j]) {
                    newBoard[height][i] *= 2
                    newBoard[height][j] = 0
                    break
                } else
                    break
            }
        }
    }
    return newBoard
}

fun List<List<Int>>.moveRight(mx: Int): List<List<Int>> {
    val newBoard = this.map { it.toMutableList() }
    val lastIndex = mx - 1
    for (height in 0..lastIndex) {
        for (i in lastIndex downTo 0) {
            if (newBoard[height][i] == 0) {
                for (j in i - 1 downTo 0)
                    if (newBoard[height][j] != 0) {
                        newBoard[height][i] = newBoard[height][j]
                        newBoard[height][j] = 0
                        break
                    }
            }
            for (j in i - 1 downTo 0) {
                if (newBoard[height][j] == 0)
                    continue
                else if (newBoard[height][i] == newBoard[height][j]) {
                    newBoard[height][i] *= 2
                    newBoard[height][j] = 0
                    break
                } else
                    break
            }
        }
    }

    return newBoard
}

fun List<List<Int>>.moveUp(mx: Int): List<List<Int>> {
    val newBoard = this.map { it.toMutableList() }
    for (width in 0 until mx){
        for (i in 0 until mx) {
            if (newBoard[i][width] == 0) {
                for (j in i+1 until mx) {
                    if (newBoard[j][width] != 0) {
                        newBoard[i][width] = newBoard[j][width]
                        newBoard[j][width] = 0
                        break
                    }
                }
            }
            for (j in i+1 until mx) {
                if (newBoard[j][width] == 0)
                    continue
                else if (newBoard[j][width] == newBoard[i][width]) {
                    newBoard[i][width] *= 2
                    newBoard[j][width] = 0
                    break
                } else
                    break
            }
        }
    }
    return newBoard
}

fun List<List<Int>>.moveDown(mx: Int): List<List<Int>> {
    val newBoard = this.map { it.toMutableList() }
    val lastIndex = mx - 1
    for (width in 0..lastIndex) {
        for (i in lastIndex downTo 0) {
            if (newBoard[i][width] == 0) {
                for (j in i - 1 downTo 0)
                    if (newBoard[j][width] != 0) {
                        newBoard[i][width] = newBoard[j][width]
                        newBoard[j][width] = 0
                        break
                    }
            }
            for (j in i - 1 downTo 0) {
                if (newBoard[j][width] == 0)
                    continue
                else if (newBoard[i][width] == newBoard[j][width]) {
                    newBoard[i][width] *= 2
                    newBoard[j][width] = 0
                    break
                } else
                    break
            }
        }
    }
    return newBoard
}

fun main() {
    val n = readln().toInt()
    val board = List(n) { readln().split(" ").map { it.toInt() }.toList() }

    var sum = 0
    fun dfs(board: List<List<Int>>, level: Int) {
        if (level >= 5) {
            sum = max(sum, board.maxOf { it.maxOf { it } })
        } else {
            dfs(board.moveLeft(n), level + 1)
            dfs(board.moveRight(n), level + 1)
            dfs(board.moveUp(n), level + 1)
            dfs(board.moveDown(n), level + 1)
        }
    }
    dfs(board, 0)
    println(sum)
}