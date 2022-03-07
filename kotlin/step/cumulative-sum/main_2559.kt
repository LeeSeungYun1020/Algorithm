import kotlin.math.max

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val num = readln().split(" ").map { it.toInt() }.toMutableList()

    for (i in 1 until n) {
        num[i] += num[i - 1]
    }

    var ans = num[k - 1]
    for (i in k until n) {
        ans = max(ans, num[i] - num[i-k])
    }
    println(ans)
}