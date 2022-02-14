import kotlin.math.min

lateinit var list: List<Pair<Int, Int>>

fun main() {
    val n = readLine()!!.toInt()
    list = List(n) { val (a, b) = readLine()!!.split(' ').map { it.toInt() }; a to b }.sortedBy { it.first }
    print(find(0, n - 1))
}

fun find(start: Int, end: Int): Int {
    if (start == end)
        return Int.MAX_VALUE

    val mid = (start + end) / 2
    val line = list[mid].first
    var distance = min(find(start, mid), find(mid + 1, end))
    val cmp = ArrayDeque<Pair<Int, Int>>()
    for (i in start..end) {
        val t = list[i].first - line
        if (t * t < distance)
            cmp.add(list[i])
    }
    cmp.sortBy { it.second }
    for (i in 0 until cmp.lastIndex) {
        for (j in i + 1..cmp.lastIndex) {
            val t = cmp[i].second - cmp[j].second
            if (t * t < distance) {
                val dx = cmp[i].first - cmp[j].first
                distance = min(distance, dx * dx + t * t)
            } else break
        }
    }
    return distance
}