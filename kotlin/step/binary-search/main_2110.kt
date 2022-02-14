import kotlin.math.max

fun main() {
    val (n, c) = readLine()!!.split(' ').map { it.toInt() }
    val house = IntArray(n) { readLine()!!.toInt() }
    house.sort()

    var start = 1
    var end = house.last() - house.first()
    var ans = 0
    while (start <= end) {
        val mid = (start + end) / 2

        var count = 1
        var pos = house[0]
        for (h in house) {
            if (h - pos >= mid) {
                pos = h
                count++
            }
        }

        if (count < c) {
            end = mid - 1
        } else {
            ans = max(ans, mid)
            start = mid + 1
        }

    }
    print(ans)
}