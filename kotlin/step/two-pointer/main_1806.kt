import kotlin.math.min

fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val number = readln().split(" ").map { it.toInt() }

    var start = 0
    var end = 0
    var sum = number[0]
    var len = 100_000_001
    while (start < n) {
        if (sum >= s) {
            len = min(len, end-start+1)
        }

        if (sum > s || end == n-1) {
            sum -= number[start]
            start++
        } else {
            end++
            sum += number[end]
        }
    }

    if (len == 100_000_001)
        println(0)
    else
        println(len)
}