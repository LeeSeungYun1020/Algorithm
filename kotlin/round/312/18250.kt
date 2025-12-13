fun main() {
    val (numberOfCities, numberOfLines) = readln().split(" ").map { it.toInt() }
    val graph = List(numberOfCities) { mutableSetOf<Int>() }
    repeat(numberOfLines) {
        val (from, to) = readln().split(" ").map { it.toInt() - 1 }
        graph[from].add(to)
        graph[to].add(from)
    }

    val visited = MutableList(numberOfCities) { graph[it].isEmpty() }
    val deque = ArrayDeque<Int>()
    var answer = 0
    var start = visited.indexOfFirstFrom(0) { !it }
    while (start != -1) {
        var count = 0
        visited[start] = true
        deque.clear()
        deque.addLast(start)
        while (deque.isNotEmpty()) {
            val current = deque.removeFirst()
            if (graph[current].size % 2 == 1) {
                count++
            }
            graph[current]
                .filter { !visited[it] }
                .also { deque.addAll(it) }
                .forEach { visited[it] = true }
        }
        if (count == 0) answer += 1
        else answer += count / 2
        start = visited.indexOfFirstFrom(start + 1) { !it }
    }
    println(answer)
}

inline fun <T> List<T>.indexOfFirstFrom(from: Int, predicate: (T) -> Boolean): Int {
    for (i in from until lastIndex) {
        if (predicate(this[i])) return i
    }
    return -1
}