import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val deque = ArrayDeque<Int>()
    for (i in 1..n) {
        val input = br.readLine().split(" ")
        when (input.first()) {
            "push" -> deque.add(input[1].toInt())
            "pop" -> bw.write("${deque.removeFirstOrNull() ?: -1}\n")
            "size" -> bw.write("${deque.size}\n")
            "empty" -> bw.write("${if (deque.isEmpty()) 1 else 0}\n")
            "front" -> bw.write("${deque.firstOrNull() ?: -1}\n")
            "back" -> bw.write("${deque.lastOrNull() ?: -1}\n")
        }
    }

    bw.flush()
    bw.close()
    br.close()
}