import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val count = br.readLine().toInt()
    val deque = ArrayDeque<Int>(count)
    for (i in 1..count){
        val command = br.readLine().split(' ')
        when(command[0]){
            "push_front" -> deque.addFirst(command[1].toInt())
            "push_back" -> deque.add(command[1].toInt())
            "pop_front" -> bw.write("${deque.removeFirstOrNull() ?: -1}\n")
            "pop_back" -> bw.write("${deque.removeLastOrNull() ?: -1}\n")
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