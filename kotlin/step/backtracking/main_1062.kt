import kotlin.math.max
import kotlin.math.min

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    if (k < 5) {
        println(0)
        return
    }
    var ans = 0
    val letter = mutableSetOf('a', 'c', 'i', 'n', 't')
    val word = List(n) { readln().toSet() - letter }//.sortedBy { it.size }
    val will = buildSet {
        word.forEach {
            addAll(it)
        }
    }.toSet()

    val selected = MutableList(will.size) { false }
    val limit = min(k-5, will.size)
    fun dfs(level: Int, prev: Int) {
        if (level >= limit) {
            var sum = 0
            for (w in word)
                if ((w - letter).isEmpty())
                    sum++
            ans = max(ans, sum)
            return
        }

        for ((idx, c) in will.withIndex()) {
            if (prev < idx && !selected[idx]) {
                selected[idx] = true
                letter += c
                dfs(level + 1, idx)
                letter -= c
                selected[idx] = false
            }
        }

    }

    dfs(0, -1)
    println(ans)
}