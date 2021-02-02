import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val count = br.readLine().toInt()
    for (i in 1..count) {
        val command = br.readLine()
        val n = br.readLine().toInt()
        val deque = ArrayDeque<Int>(n)
        val list = br.readLine().split(',')
        if (list[0] != "[]")
            list.map {
                it.toIntOrNull() ?: it.removePrefix("[").removeSuffix("]").toInt()
            }.toCollection(deque)
        var status = true
        var reverse = false
        for (c in command) {
            when (c) {
                'R' -> reverse = !reverse
                'D' -> if (deque.isEmpty()) {
                    status = false
                    break
                } else {
                    if (reverse)
                        deque.removeLast()
                    else
                        deque.removeFirst()
                }
            }
        }
        if (status) {
            bw.write("[")
            if (deque.isNotEmpty())
                while (true) {
                    if (reverse)
                        bw.write("${deque.removeLast()}")
                    else
                        bw.write("${deque.removeFirst()}")
                    if (deque.isEmpty()) break
                    else bw.write(",")
                }
            bw.write("]\n")
        } else {
            bw.write("error\n")
        }
    }
    bw.flush()
    bw.close()
    br.close()
}