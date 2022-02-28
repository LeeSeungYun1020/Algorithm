import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine()!!.split(" ").map { it.toInt() }
    val number = br.readLine()!!.split(" ").map { it.toInt() }.sorted()
    // m개로 구성된 수열 출력
    val path = Array(m) { 0 }
    fun dfs(level: Int) {
        if (level == m) {
            for (p in path) {
                bw.write("${number[p]} ")
            }
            bw.write("\n")
            return
        }
        val start = path.getOrElse(level - 1) { 0 }
        for (i in start until n) {
            path[level] = i
            dfs(level + 1)
        }
    }
    dfs(0)
    bw.flush()
    bw.close()
    br.close()
}