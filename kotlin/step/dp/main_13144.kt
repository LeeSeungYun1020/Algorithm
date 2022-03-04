fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }

    val dp = MutableList(n) { 0 }
    val deque = ArrayDeque<Int>()
    val set = mutableSetOf<Int>()

    for (i in 0 until n) {
        if (list[i] in set) {
            while (deque.isNotEmpty()) {
                val first = deque.removeFirst()
                set.remove(first)
                if (first == list[i]) break
            }
        }
        deque.add(list[i])
        set.add(list[i])
        dp[i] = deque.count()
    }
    println(dp.sumOf { it.toLong() })
}