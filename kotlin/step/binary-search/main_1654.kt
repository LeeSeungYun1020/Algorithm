import kotlin.math.max

lateinit var array: IntArray
var limit = 0

fun main() {
    val (k, n) = readLine()!!.split(' ').map { it.toInt() }
    limit = n
    array = IntArray(k) { readLine()!!.toInt() }
    array.sort()
    print(cut(1, array.last()))
}

fun cut(start: Int, end: Int): Int {
    if (start > end)
        return 0
    val mid = ((start.toLong() + end) / 2).toInt()
    if (mid == 0)
        return 0
    return if (array.sumBy { it / mid } < limit) {
        cut(start, mid - 1)
    } else {
        max(mid, cut(mid + 1, end))
    }
}