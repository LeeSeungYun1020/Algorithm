import kotlin.math.absoluteValue

data class Land(val x: Int, val y: Int, val type: Int)

const val INVALID = -1

fun main() {
    val (n, l, r) = readln().split(" ").map { it.toInt() }
    val country = List(n) { readln().split(" ").map { it.toInt() }.toMutableList() }
    val validated = List(n) { MutableList(n) { INVALID } }

    fun bfs(i: Int, j: Int, t: Int): Pair<Int, Int> {
        var sum = country[i][j]
        var count = 1
        val deque = ArrayDeque<Land>()
        deque.add(Land(i, j, t))
        validated[i][j] = t
        while (deque.isNotEmpty()) {
            val (x, y, type) = deque.removeFirst()
            if (x-1 >= 0 && validated[x-1][y] == INVALID && (country[x][y]-country[x-1][y]).absoluteValue in l..r) {
                validated[x-1][y] = type
                sum += country[x-1][y]
                count += 1
                deque.add(Land(x-1, y, type))
            }
            if (y-1 >= 0 && validated[x][y-1] == INVALID && (country[x][y]-country[x][y-1]).absoluteValue in l..r) {
                validated[x][y-1] = type
                sum += country[x][y-1]
                count += 1
                deque.add(Land(x, y-1, type))
            }
            if (x+1 < n && validated[x+1][y] == INVALID && (country[x][y]-country[x+1][y]).absoluteValue in l..r) {
                validated[x+1][y] = type
                sum += country[x+1][y]
                count += 1
                deque.add(Land(x+1, y, type))
            }
            if (y+1 < n && validated[x][y+1] == INVALID && (country[x][y]-country[x][y+1]).absoluteValue in l..r) {
                validated[x][y+1] = type
                sum += country[x][y+1]
                count += 1
                deque.add(Land(x, y+1, type))
            }
        }
        return sum to count
    }

    for (move in 0..2000) {
        // 연합 파악하기
        var type = 0
        val sum = mutableListOf<Int>()
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (validated[i][j] == INVALID) {
                    val (s, c) = bfs(i, j, type)
                    sum.add(s/c)
                    type += 1
                }
            }
        }
        if (sum.size == n * n) {
            println(move)
            return
        }

        // 연합별 인구 계산
        for (i in 0 until n) {
            for (j in 0 until n) {
                country[i][j] = sum[validated[i][j]]
                validated[i][j] = INVALID
            }
        }
    }
}