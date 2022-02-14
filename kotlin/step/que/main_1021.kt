fun main() {
    val n = readLine()!!.split(' ')[0].toInt()
    val pos = readLine()!!.split(' ').map { it.toInt() }
    val deque = ArrayDeque<Int>(n)
    (1..n).toCollection(deque)
    var ans = 0
    for (p in pos) {
        if (deque.firstOrNull() == p)
            deque.removeFirst()
        else {
            val index = deque.indexOf(p)
            ans += if (index < deque.lastIndex - index + 1) {
                for (i in 1..index)
                    deque.addLast(deque.removeFirst())
                index
            } else {
                for (i in 1..deque.lastIndex - index + 1)
                    deque.addFirst(deque.removeLast())
                deque.lastIndex - index + 1
            }
            deque.removeFirst()
        }
    }
    println(ans)
}