import kotlin.math.max

fun main() {
    val (numberOfBuildings, numberOfDays) = readln().split(" ").map { it.toInt() }
    val parent = MutableList(numberOfBuildings) { it }
    val size = MutableList(numberOfBuildings) { 1 }
    val next = MutableList(numberOfBuildings) { it + 1 }
    val ranges = List(numberOfDays) { readln().split(" ").map { it.toInt() - 1 }.let { it[0]..it[1] } }
    var answer = 0
    var accumulator = 0

    fun find(n: Int): Int {
        if (n == parent[n]) return n
        parent[n] = find(parent[n])
        return parent[n]
    }

    fun union(a: Int, b: Int): Boolean {
        val pA = find(a)
        val pB = find(b)
        when {
            pA == pB -> return false
            size[pA] > size[pB] -> {
                parent[pB] = pA
                size[pA] += size[pB]
            }
            else -> {
                parent[pA] = pB
                size[pB] += size[pA]
            }
        }
        return true
    }

    ranges.forEach { range ->
        accumulator++
        var i = range.first
        var count = 0
        while (i < range.last) {
            if (find(i) != find(i + 1)) {
                union(i, i + 1)
                count++
            }
            val nextValue = next[i]
            next[i] = max(nextValue, range.last)
            i = nextValue
        }
        if (accumulator >= count) accumulator -= count
        else {
            answer += count - accumulator
            accumulator = 0
        }
    }
    println(answer)
}