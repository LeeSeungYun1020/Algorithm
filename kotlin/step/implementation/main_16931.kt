import kotlin.math.absoluteValue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val paper = List(n) { readln().split(" ").map { it.toInt() } }
    var area = n * m * 2
    for (i in 0 until n) {
        area += paper[i][0]
        for (j in 1 until m) {
            area += (paper[i][j-1] - paper[i][j]).absoluteValue
        }
        area += paper[i][m-1]
    }
    for (i in 0 until m) {
        area += paper[0][i]
        for (j in 1 until n) {
            area += (paper[j-1][i] - paper[j][i]).absoluteValue
        }
        area += paper[n-1][i]
    }
    println(area)
}