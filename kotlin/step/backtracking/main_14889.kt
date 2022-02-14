import kotlin.math.absoluteValue
import kotlin.math.min

var n = 0
var minValue = Int.MAX_VALUE
lateinit var arr: Array<IntArray>
lateinit var team1: BooleanArray

fun main() {
    n = readLine()!!.toInt()
    arr = Array<IntArray>(n) { readLine()!!.split(' ').map { it.toInt() }.toIntArray() }
    team1 = BooleanArray(n)
    dfs(0, 0)
    println(minValue)
}

fun dfs(depth: Int, index: Int) {
    if (depth == n / 2) {
        var sum = 0
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (i != j) {
                    if (team1[i] && team1[j])
                        sum += (arr[i][j] + arr[j][i])
                    else if (!team1[i] && !team1[j])
                        sum -= (arr[i][j] + arr[j][i])
                }
            }
        }
        minValue = min(minValue, sum.absoluteValue)
    } else {
        for (i in index until n) {
            if (!team1[i]) {
                team1[i] = true
                dfs(depth + 1, i + 1)
                team1[i] = false
            }
        }
    }
}