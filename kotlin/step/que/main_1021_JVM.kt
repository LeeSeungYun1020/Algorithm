import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().split(' ')[0].toInt()
    val pos = br.readLine().split(' ').map { it.toInt() }
    val deque = ArrayDeque<Int>(n)
    (1..n).toCollection(deque)
    var ans = 0
    for (p in pos) {
        if (deque.firstOrNull() == p)
            deque.removeFirst()
        else {
            val index = deque.indexOf(p)
            if (index < deque.lastIndex - index + 1) {
                for (i in 1..index)
                    deque.addLast(deque.removeFirst())
                ans += index
            } else {
                for (i in 1..deque.lastIndex - index + 1)
                    deque.addFirst(deque.removeLast())
                ans += deque.lastIndex - index + 1
            }
            deque.removeFirst()
        }
    }
    bw.write("$ans\n")
    bw.flush()
    bw.close()
    br.close()
}