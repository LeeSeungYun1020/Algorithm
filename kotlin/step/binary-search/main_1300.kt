import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()
    var start = 1
    var end = k
    var ans = 0
    while (start <= end) {
        val mid = (start + end) / 2
        var count = 0
        for (i in 1..n)
            count += min(mid / i, n)

        if (count < k) {
            start = mid + 1
        } else {
            ans = mid
            end = mid - 1
        }
    }
    println(ans)
}