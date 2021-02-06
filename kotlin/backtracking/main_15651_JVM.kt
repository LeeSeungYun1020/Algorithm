import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var array: Array<Int>
val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, m) = br.readLine()!!.split(' ').map { it.toInt() }
    array = Array(m) { 0 }
    dfs(0, n, m)
    bw.flush()
    bw.close()
    br.close()
}

fun dfs(depth: Int, n: Int, m: Int) {
    if (depth == m) {
        array.forEach {
            bw.write("$it ")
        }
        bw.write("\n")
    } else {
        for (i in 0 until n) {
            array[depth] = i + 1
            dfs(depth + 1, n, m)
        }
    }
}