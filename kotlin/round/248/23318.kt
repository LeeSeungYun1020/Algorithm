import kotlin.math.max
import kotlin.math.min

fun main() {
    val (height, width) = readln().split(" ").map { it.toInt() }
    val (heightCut, widthCut) = readln().split(" ").map { it.toInt() }
    val board = List(height) { readln().split(" ").map { it.toInt() } }

    val sumBoard = List(height + 1) { MutableList(width + 1) { 0 } }
    for (i in 1..height) {
        for (j in 1..width) {
            sumBoard[i][j] = board[i - 1][j - 1] + sumBoard[i - 1][j] + sumBoard[i][j - 1] - sumBoard[i - 1][j - 1]
        }
    }

    fun calcSum(x1: Int, y1: Int, x2: Int, y2: Int): Int {
        return sumBoard[x2][y2] - sumBoard[x1 - 1][y2] - sumBoard[x2][y1 - 1] + sumBoard[x1 - 1][y1 - 1]
    }

    fun permutation(n: Int, max: Int, action: ((List<Int>) -> Unit)) {
        fun inner(level: Int, list: MutableList<Int>) {
            if (level == n) {
                action(list)
            } else {
                for (i in (list.getOrElse(level - 1) { 0 }) + 1..max) {
                    list[level] = i
                    inner(level + 1, list)
                }
            }
        }
        inner(0, MutableList(n + 1) { 0 }.also { it[n] = max })
    }

    var ans = Int.MAX_VALUE
    permutation(heightCut, height) { hCutList ->
        permutation(widthCut, width) { wCutList ->
            var mx = 0
            var pHCut = 1
            find@ for (hCut in hCutList) {
                var pWCut = 1
                for (wCut in wCutList) {
                    mx = max(mx, calcSum(pHCut, pWCut, hCut, wCut))
                    if (mx >= ans) break@find
                    pWCut = wCut + 1
                }
                pHCut = hCut + 1
            }
            ans = min(ans, mx)
        }
    }

    println(ans)
}