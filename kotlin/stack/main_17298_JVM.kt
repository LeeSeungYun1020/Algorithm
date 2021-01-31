import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    br.readLine()
    val num = br.readLine()!!.split(' ').map { it.toInt() }
    val list = mutableListOf<Pair<Int, Int>>()
    val ans = IntArray(num.size) { -1 }
    num.forEachIndexed { idx, n ->
        if (list.isEmpty())
            list.add(idx to n)
        else {
            if (list.last().second < n)
                while (list.isNotEmpty() && list.last().second < n){
                    ans[list.removeLast().first] = n
                }
            list.add(idx to n)
        }
    }
    ans.forEach { bw.write("$it ") }
    bw.flush()
    bw.close()
    br.close()
}