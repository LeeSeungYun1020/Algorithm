import kotlin.math.max
import kotlin.math.min

lateinit var array: IntArray

fun main() {
    while (true) {
        array = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
        if (array[0] == 0)
            return
        println(cut(1, array[0]))
    }
}

fun cut(start: Int, end: Int): Long {
    if (start == end) {
        return array[start].toLong()
    }

    val mid = (start + end) / 2
    var result = max(cut(start, mid), cut(mid + 1, end))

    var low = mid
    var high = mid + 1
    var height = min(array[low], array[high]).toLong()
    result = max(result, height * 2)

    while (start < low || high < end) {
        height = when {
            low <= start -> {
                min(height, array[++high].toLong())
            }
            end <= high -> {
                min(height, array[--low].toLong())
            }
            array[low - 1] > array[high + 1] -> {
                min(height, array[--low].toLong())
            }
            else -> {
                min(height, array[++high].toLong())
            }
        }
        result = max(result, height * (high - low + 1))
    }
    return result
}