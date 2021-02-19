import kotlin.math.max

fun main() {
    val (_, length) = readLine()!!.split(' ').map { it.toLong() }
    val tree = readLine()!!.split(' ').map{ it.toInt() }

    var start = 1L
    var end = tree.maxOrNull()?.toLong() ?: 0L
    var ans = 0L
    while (start <= end) {
        val mid = (start + end) / 2
        if (mid == 0L) break
        if (tree.sumOf { if (it - mid > 0) it - mid else 0 } >= length) {
            ans = max(ans, mid)
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    print(ans)
}