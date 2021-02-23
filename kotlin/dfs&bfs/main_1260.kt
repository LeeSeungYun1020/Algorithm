import kotlin.math.max
import kotlin.math.min

fun main() {
    val (n, m, v) = readLine()!!.split(' ').map { it.toInt() }
    val set = mutableSetOf<Pair<Int, Int>>()
    for (i in 1..m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        set.add(min(a, b) to max(a, b))
    }
    dfs(set.toMutableSet(), v)
    bfs(set.toMutableSet(), v)
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
    visited.forEach { print("$it ") }
    println()
}

fun bfs(set: MutableSet<Pair<Int, Int>>, start: Int) {
    val visited = ArrayDeque<Int>()
    val deq = ArrayDeque<Int>()
    deq.add(start)
    var pos: Int
    while (deq.isNotEmpty()) {
        pos = deq.removeFirst()
        if (pos in visited.map { it }) continue
        visited.add(pos)
        val filtered = set.filter { it.first == pos || it.second == pos }
        if (filtered.isNotEmpty()) {
            set.removeAll(filtered)
            deq.addAll(filtered.map {
                if (it.first == pos) it.second else it.first
            }.sorted())
        }
    }
    visited.forEach { print("$it ") }
}