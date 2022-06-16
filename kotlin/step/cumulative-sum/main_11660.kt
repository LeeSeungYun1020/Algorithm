import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val num = List(n) { br.readLine().split(" ").map { it.toInt() } }
    val sum = List(n) { MutableList(n) { 0 } }
    for (i in 0 until n) {
        sum[i][0] = num[i][0]
        for (j in 1 until n) {
            sum[i][j] = sum[i][j-1] + num[i][j]
        }
    }

    for (i in 1 until n) {
        for (j in 0 until n) {
            sum[i][j] += sum[i - 1][j]
        }
    }

    for (t in 1..m) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() - 1 }
        bw.write("${
            sum[x2][y2]
                    - (sum.getOrNull(x1-1)?.get(y2)?: 0)
                    - sum[x2].getOrElse(y1 - 1) { 0 }
                    + (sum.getOrNull(x1 - 1)?.getOrElse(y1 - 1){ 0 } ?: 0)
        }\n")
    }
    bw.flush()
    bw.close()
    br.close()
}