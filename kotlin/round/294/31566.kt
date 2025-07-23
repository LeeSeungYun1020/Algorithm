fun main() {
    val (numberOfLanguages, numberOfData, numberOfQueries) = readln().split(" ").map { it.toInt() }
    val originalGraph = List(numberOfLanguages) { start ->
        MutableList(numberOfLanguages) { end ->
            if (start == end) 0 else Int.MAX_VALUE
        }
    }
    repeat(numberOfData) {
        val (start, end, cost) = readln().split(" ").map { it.toInt() - 1 }
        originalGraph[start][end] = cost + 1
    }

    val calculator =
        List(numberOfLanguages) { List(numberOfLanguages) { MutableList(numberOfLanguages) { -1 } } }

    fun calc(exclude: Int) {
        val graph = originalGraph.map { it.toMutableList() }
        for (m in 0 until numberOfLanguages) {
            if (m == exclude) continue
            for (s in 0 until numberOfLanguages) {
                if (s == exclude) continue
                for (e in 0 until numberOfLanguages) {
                    if (e == exclude) continue
                    if (graph[s][m] != Int.MAX_VALUE && graph[m][e] != Int.MAX_VALUE)
                        graph[s][e] = minOf(graph[s][e], graph[s][m] + graph[m][e])
                }
            }
        }
        for (s in 0 until numberOfLanguages) {
            if (s == exclude) continue
            for (e in 0 until numberOfLanguages) {
                if (e == exclude) continue
                calculator[s][exclude][e] = graph[s][e]
            }
        }
    }

    buildString {
        repeat(numberOfQueries) {
            val (start, exclude, end) = readln().split(" ").map { it.toInt() - 1 }
            if (calculator[start][exclude][end] == -1) {
                calc(exclude)
            }
            calculator[start][exclude][end].run {
                if (this == Int.MAX_VALUE) appendLine("No") else appendLine(this)
            }
        }
    }.run { println(this) }
}