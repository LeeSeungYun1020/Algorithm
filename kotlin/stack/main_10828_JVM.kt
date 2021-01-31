import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val count = br.readLine().toInt()
    val array = IntArray(count)
    var index = 0
    for (i in 1..count){
        val command = br.readLine()!!.split(' ')
        when(command.first()){
            "push" -> array[index++] = command.last().toInt()
            "pop" -> bw.write("${if (index != 0) array[--index] else -1}\n")
            "size" -> bw.write("$index\n")
            "empty" -> bw.write("${if (index == 0) 1 else 0}\n")
            "top" -> bw.write("${if (index != 0) array[index - 1] else -1}\n")
        }
    }
    bw.flush()
    bw.close()
    br.close()
}