import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val answer = mutableListOf<Int>()
    repeat(br.readLine().toInt()) {
        val size = br.readLine().toInt()
        if (size <= 2) {
            repeat(size - 1) { br.readLine() }
            answer.add(0)
            return@repeat
        }

        val edges = List(size - 1) { br.readLine().split(" ").map { it.toInt() - 1 }.let { it[0] to it[1] } }
        val board = List(size) { mutableSetOf<Int>() }
        edges.forEach { (a, b) ->
            board[a].add(b)
            board[b].add(a)
        }
        val order = board.withIndex().map { V(it.index, it.value.size) }.sortedByDescending { it.degree }
        val topDegree = order.first().degree

        // 인접
        val adjacency = edges.maxOf { (u, v) -> board[u].size + board[v].size } - 2

        // 비인접
        var nonAdjacency = 0
        val visited = BooleanArray(size) { false }
        val marked = mutableListOf<Int>()
        for ((vertex, degree) in order) {
            if (degree + topDegree < nonAdjacency) break
            if (!visited[vertex]) {
                visited[vertex] = true
                marked.add(vertex)
            }
            board[vertex].forEach {
                if (!visited[it]) {
                    visited[it] = true
                    marked.add(it)
                }
            }
            order.firstOrNull { !visited[it.vertex] }?.let {
                nonAdjacency = max(nonAdjacency, board[vertex].size + it.degree - 1)
            }
            marked.onEach { visited[it] = false }.clear()
        }
        answer.add(max(adjacency, nonAdjacency))
    }
    bw.append(answer.joinToString(separator = "\n"))
    bw.flush()
    bw.close()
    br.close()
}

data class V(val vertex: Int, val degree: Int)
