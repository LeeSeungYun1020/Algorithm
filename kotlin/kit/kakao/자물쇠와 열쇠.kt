
class Solution {
    fun rotate(board: List<MutableList<Int>>): List<MutableList<Int>> {
        val n = board.size
        val result = List(n) { MutableList(n) { 0 } }
        for (i in 0 until n) {
            for (j in 0 until n) {
                result[i][j] = board[j][n - i - 1]
            }
        }
        return result
    }

    fun check(board: List<MutableList<Int>>, key: List<MutableList<Int>>): Boolean {
        for (i in 0..board.size - key.size) {
            for (j in 0..board[0].size - key[0].size) {
                for (x in i until i + key.size)
                    for (y in j until j + key[0].size)
                        board[x][y] += key[x - i][y - j]
                var flag = true
                for (x in key.size until board.size - key.size) {
                    for (y in key[0].size until board[0].size - key[0].size) {
                        if (board[x][y] != 1) {
                            flag = false
                            break
                        }
                    }
                    if (!flag) break
                }
                if (flag) return true


                for (x in i until i + key.size)
                    for (y in j until j + key[0].size)
                        board[x][y] -= key[x - i][y - j]
            }
        }
        return false
    }

    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        var rotatableKey = key.map { it.toMutableList() }
        val board = List(lock.size + key.size * 2) { MutableList(lock.size + key.size * 2) { 0 } }

        for (i in lock.indices) {
            for (j in lock.indices) {
                board[i + key.size][j + key.size] = lock[i][j]
            }
        }

        for (i in 0..2) {
            if (check(board, rotatableKey)) return true
            rotatableKey = rotate(rotatableKey)
        }
        if (check(board, rotatableKey)) return true
        return false
    }
}