fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val num = readln().split(" ").map { it.toInt() }
    val sum = MutableList(n+1) { 0 }
    for (i in 1..sum.lastIndex) {
        sum[i] = sum[i - 1] + num[i - 1]
    }

    for (i in 1..m) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        println(sum[end] - sum[start - 1])
    }
}