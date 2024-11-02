fun main() {
    val deque = ArrayDeque<Int>()
    deque.addAll((readln().toInt() downTo 1))
    println(buildList<Int> {
        while (deque.isNotEmpty()) {
            add(
                if (deque.size % 2 == 0) {
                    deque.removeLast()
                } else {
                    deque.removeFirst()
                }
            )
        }
    }.reversed().joinToString(separator = " "))
}