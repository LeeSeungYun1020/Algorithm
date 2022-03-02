import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    var set = 0
    for (i in 1..n) {
        val oper = br.readLine().split(" ")
        val num = (oper.getOrNull(1)?.toInt() ?: 0) - 1
        when(oper[0]) {
            "add" -> set = set or (1 shl num)
            "remove" -> set = set and (1 shl num).inv()
            "check" -> bw.write("${set shr num and 1}\n")
            "toggle" -> {
                val mask = 1 shl num
                set = if (set and mask > 0) set - mask else set + mask
            }
            "all" -> set = 0b11111111111111111111
            "empty" -> set = 0
        }
    }
    bw.flush()
    bw.close()
    br.close()
}