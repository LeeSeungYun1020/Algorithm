fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val num = readln().split(" ").map { it.toInt() % m }
    val sum = num.toMutableList()
    val remainder = MutableList(m) { 0 }

    // (sum[i] - sum[j]) % m == 0
    // sum[i] % m == sum[j] % m
    remainder[sum[0]]++
    for (i in 1 until n) {
        sum[i] = (sum[i] + sum[i - 1]) % m
        remainder[sum[i]]++
    }
    // 0..x case + x..y case
    println(remainder.sumOf {
      it.toLong() * (it - 1) / 2
    } + remainder[0])
}