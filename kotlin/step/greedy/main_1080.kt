fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val origin = List(n) { readln().map { it == '1' }.toMutableList() }
    val result = List(n) { readln().map { it == '1' } }

    if (n - 2 <= 0 || m - 2 <= 0) {
        if (origin == result)
            println(0)
        else
            println(-1)
        return
    }

    // 3x3 변환
    fun change(x: Int, y: Int): Boolean {
        if (x + 2 >= n || y + 2 >= m)
            return false
        for (i in x..x + 2)
            for (j in y..y + 2)
                origin[i][j] = !origin[i][j]
        return true
    }

    var ans = 0

    for (i in 0 until n - 2)
        for (j in 0 until m - 2) {
            if (origin[i][j] != result[i][j]) {
                change(i, j)
                ans++
            }
        }

    if (origin == result)
        println(ans)
    else
        println(-1)
}