import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val set = mutableSetOf<Pair<Int, Int>>()
    for (i in 1..m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        set.add(min(a, b) to max(a, b))
    }
    dfs(set.toMutableSet(), 1)
}

fun dfs(set: MutableSet<Pair<Int, Int>>, start: Int) {
    val visited = ArrayDeque<Int>()
    val deq = ArrayDeque<Int>()
    deq.add(start)
    var pos: Int
    while (deq.isNotEmpty()) {
        pos = deq.removeLast()
        if (pos in visited) continue
        visited.add(pos)
        val filtered = set.filter { it.first == pos || it.second == pos }
        if (filtered.isNotEmpty()) {
            set.removeAll(filtered)
            deq.addAll(filtered.map {
                if (it.first == pos) it.second else it.first
            }.sortedDescending())
        }
    }
    println(visited.size - 1)
}