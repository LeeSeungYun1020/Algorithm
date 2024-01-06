fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val board = List(n) { readln().map { it == 'B' } }
    val calculateA = List(n + 1) { MutableList(m + 1) { 0 } }
    val calculateB = List(n + 1) { MutableList(m + 1) { 0 } }

    var start = true
    for (i in 1..n) {
        var inner = start
        for (j in 1..m) {
            val flag = board[i-1][j-1] == inner
            val a = if (flag) 1 else 0
            val b = if (flag) 0 else 1
            calculateA[i][j] = a + calculateA[i][j - 1] - calculateA[i - 1][j - 1] + calculateA[i - 1][j]
            calculateB[i][j] = b + calculateB[i][j - 1] - calculateB[i - 1][j - 1] + calculateB[i - 1][j]
            inner = !inner
        }
        start = !start
    }

    var answer = n * m
    for (i in k..n) {
        for (j in k..m) {
            val a = calculateA[i][j] - calculateA[i][j - k] + calculateA[i - k][j - k] - calculateA[i - k][j]
            val b = calculateB[i][j] - calculateB[i][j - k] + calculateB[i - k][j - k] - calculateB[i - k][j]
            answer = minOf(answer, a, b)
        }
    }
    println(answer)
}