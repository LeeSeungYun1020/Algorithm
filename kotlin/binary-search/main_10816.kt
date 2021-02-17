import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    br.readLine()
    val map = br.readLine()!!.split(' ').map { it.toInt() }.groupingBy { it }.eachCount()
    br.readLine()
    br.readLine()!!.split(' ').map { it.toInt() }.forEach { check ->
        bw.write("${map[check] ?: 0} ")
    }
    bw.flush()
    bw.close()
    br.close()
}