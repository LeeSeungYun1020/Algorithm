import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val tabs = List(br.readLine().toInt()) { br.readLine().toInt() }
    val start = tabs.runningFold(0L) { acc, i -> acc + i }
    val width = br.readLine().toDouble()
    val halfWidth = width / 2
    val limit = max(start.last() - width, 0.0)
    val center = MutableList<String?>(tabs.size) { null }

    repeat(br.readLine().toInt()) {
        val click = br.readLine().toInt() - 1
        if (center[click] != null) {
            bw.appendLine(center[click])
            return@repeat
        }
        val calc = start[click] + tabs[click].toDouble() / 2 - halfWidth
        val answer = "%.2f".format(
            if (calc < 0) 0.0
            else if (calc >= limit) limit
            else calc
        )
        center[click] = answer
        bw.appendLine(answer)
    }

    bw.flush()
    bw.close()
    br.close()
}