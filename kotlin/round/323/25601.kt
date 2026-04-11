fun main() {
    val map = mutableMapOf<String, MutableSet<String>>()
    List(readln().toInt() - 1) { readln().split(" ") }.forEach { (child, parent) ->
        if (!map.containsKey(parent)) map[parent] = mutableSetOf()
        map.getValue(parent).add(child)
    }
    fun find(start: String, end: String): Boolean {
        val visited = mutableSetOf<String>()
        val deque = ArrayDeque<String>()
        deque.add(start)
        while (deque.isNotEmpty()) {
            val current = deque.removeFirst()
            if (current == end) {
                return true
            }
            map[current]?.forEach {
                if (!visited.contains(it)) {
                    visited.add(it)
                    deque.addLast(it)
                }
            }
        }
        return false
    }
    readln().split(" ").let { (t1, t2) ->
        if (find(t1, t2) || find(t2, t1)) 1 else 0
    }.run(::print)
}