fun main() {
    repeat(readln().toInt()) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val selected = MutableList(n + 1) { false }
        val deque = ArrayDeque<Int>()

        var cM = m
        for (i in n - 1 downTo 0) {
            if (cM >= i) {
                selected[n - i] = true
                cM -= i
                deque.add(n - i)
            }.

        }
        for (i in n downTo 1) if (!selected[i]) {
            deque.add(i);
        }
        println(deque.reversed().joinToString(separator = " "))
    }
}