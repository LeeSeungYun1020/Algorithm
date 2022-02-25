import kotlin.math.max

data class Consult(val start: Int, val end: Int, val pay: Int)

fun main() {
    val n = readLine()!!.toInt()
    val consulting = List(n) { idx ->
        val (t, p) = readLine()!!.split(" ").map { it.toInt() }
        // 시작일, 종료일, 금액
        Consult(idx, idx + t - 1, p)
    }.sortedBy { it.end }

    var idx = 0
    val pay = MutableList(n) { 0 }
    if (consulting[0].end == 0) {
        pay[0] = consulting[0].pay
        idx = 1
    }


    for (i in 1.until(n)) {
        pay[i] = pay[i-1]
        for (j in idx.until(n)) {
            idx = j
            if (consulting[j].end == i) {
                pay[i] = max(pay[i], (pay.getOrNull(consulting[j].start - 1) ?: 0) + consulting[j].pay)
            } else {
                break
            }
        }
    }
    println(pay.last())
}