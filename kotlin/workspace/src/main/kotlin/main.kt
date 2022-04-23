fun main() {
    val (N, M) = readln().split(" ").map { it.toLong() }
    val num = readln().split(" ").map { it.toInt() }
    var low = 0
    var high = 0
    var sum = 0L
    var count = 0
    while (true) {
        if (sum >= M) {
            sum -= num[low]
            low++
        } else if (high == N.toInt()) {
            break
        } else {
            sum += num[high]
            high++
        }

        if (sum == M) {
            count++
        }
    }
    println(count)
}
