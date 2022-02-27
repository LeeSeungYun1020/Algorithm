import kotlin.math.max

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val paper = List(n) { readLine()!!.split(" ").map { it.toInt() } }

    val case = listOf(
        listOf(0 to 1, 0 to 2, 0 to 3),
        listOf(0 to 1, 1 to 0, 1 to 1),
        listOf(1 to 0, 2 to 0, 3 to 0),
        listOf(1 to 0, 2 to 0, 2 to 1),
        listOf(1 to 0, 0 to 1, 0 to 2),
        listOf(0 to 1, 1 to 1, 2 to 1),
        listOf(0 to 1, 0 to 2, -1 to 2),
        listOf(0 to 1, -1 to 1, -2 to 1),
        listOf(0 to 1, 0 to 2, 1 to 2),
        listOf(0 to 1, 1 to 0, 2 to 0),
        listOf(1 to 0, 1 to 1, 1 to 2),
        listOf(1 to 0, 1 to 1, 2 to 1),
        listOf(0 to 1, -1 to 1, -1 to 2),
        listOf(-1 to 0, -1 to 1, -2 to 1),
        listOf(0 to 1, 1 to 1, 1 to 2),
        listOf(-1 to 1, 0 to 1, 1 to 1),
        listOf(0 to 1, 0 to 2, -1 to 1),
        listOf(1 to 0, 2 to 0, 1 to 1),
        listOf(0 to 1, 0 to 2, 1 to 1),
    )

    var ans = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            for (cs in case) {
                var sum = paper[i][j]
                cs.forEach { (x, y) ->
                    if (i + x in 0 until n && j + y in 0 until m)
                        sum += paper[i + x][j + y]
                }
                ans = max(ans, sum)
            }
        }
    }
    println(ans)
}