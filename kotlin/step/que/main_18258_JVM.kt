import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val count = br.readLine().toInt()
    val array = IntArray(count)
    var start = 0
    var end = 0
    for (i in 1..count){
        val command = br.readLine()!!.split(' ')
        when(command.first()){
            "push" -> array[end++] = command.last().toInt()
            "pop" -> bw.write("${if (end != start) array[start++] else -1}\n")
            "size" -> bw.write("${end - start}\n")
            "empty" -> bw.write("${if (end == start) 1 else 0}\n")
            "front" -> bw.write("${if (end != start) array[start] else -1}\n")
            "back" -> bw.write("${if (end != start) array[end - 1] else -1}\n")
        }
    }
    bw.flush()
    bw.close()
    br.close()
}