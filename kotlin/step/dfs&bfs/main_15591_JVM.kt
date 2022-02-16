@file:Suppress("DuplicatedCode")

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, Q) = br.readLine()!!.split(" ").map { it.toInt() }

    val move = List(N + 1) { mutableMapOf<Int, Int>() }
    for (i in 1 until N){
        val (p, q, r) = br.readLine()!!.split(" ").map { it.toInt() }
        move[p][q] = r
        move[q][p] = r
    }


    for (i in 1..Q){
        val (k, v) = br.readLine()!!.split(" ").map { it.toInt() }

        val queue = ArrayDeque<Int>()
        val visited = BooleanArray(N + 1) { false }
        queue.add(v)
        visited[v] = true

        var count = 0
        while (queue.isNotEmpty()) {
            val now = queue.removeFirst()
            move[now].filter { !visited[it.key] && it.value >= k }.map { it.key }.forEach {
                queue.add(it)
                visited[it] = true
                count++
            }
        }
        // k에 따른 v 영상 수 출력
        bw.write("$count\n")
    }

    bw.flush()
    bw.close()
    br.close()
}