import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val input = BufferedReader(InputStreamReader(System.`in`)).use { it.readLines() }

    repeat(input[0].toInt()) {
        val n = input[it + 1].toLong()
        bw.write(((n shl 1) - (n and 1)).toString())
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}

// readln으로 시간 초과
// fun main() {
//    buildString {
//        repeat(readln().toInt()) {
//            val n = readln().toLong()
//            appendLine((n shl 1) - (n and 1))
//        }
//    }.run(::print)
//}