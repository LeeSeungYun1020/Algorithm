fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = List(n) { MutableList(n) { false } }
    for (i in 1..m) {
        val (a, b) = readln().split(" ").map { it.toInt() - 1 }
        graph[a][b] = true
        graph[b][a] = true
    }

    val team = MutableList(n) { -1 }
    var ans = 0
    for (i in 0 until n) {
        if (team[i] == -1) {
            ans += 1
            team[i] = i
            val deque = ArrayDeque<Int>()
            deque.add(i)
            while (deque.isNotEmpty()) {
                val value = deque.removeFirst()
                for (j in 0 until n) {
                    if (graph[value][j] && team[j] == -1) {
                        team[j] = i
                        deque.add(j)
                    }
                }
            }
        }
    }
    println(ans)
}