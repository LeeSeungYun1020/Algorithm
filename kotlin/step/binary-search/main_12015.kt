import kotlin.math.min

fun main() {
    readLine()
    val list = readLine()!!.split(' ').map { it.toInt() }
    val subList = mutableListOf(list[0])

    list.forEach { value ->
        if (value > subList.last())
            subList.add(value)
        else {
            var start = 0
            var end = subList.lastIndex
            var idx = end
            while (start <= end) {
                val mid = (start + end) / 2
                if (subList[mid] < value)
                    start = mid + 1
                else {
                    idx = min(idx, mid)
                    end = mid - 1
                }
            }
            subList[idx] = value
        }
    }
    print(subList.size)
}