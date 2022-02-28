import kotlin.math.max

data class Work(val start: Int, val end: Int, val pay: Int)

fun main() {
    val n = readLine()!!.toInt()
    val list = List(n) {
        val (t, p) = readLine()!!.split(" ").map { it.toInt() }
        Work(start = it, end = it + t - 1, pay = p)
    }.sortedBy { it.end }
    val table = MutableList(n) { 0 }
    var checked = 0
    for (day in 0 until n) {
        table[day] = table.getOrElse(day - 1) { 0 }
        for (i in checked until n) {
            val work = list[i]
            if (work.end == day) {
                table[day] = max(table[day], table.getOrElse(work.start - 1){ 0 } + work.pay)
                checked = i + 1
            } else break
        }
    }
    println(table.last())
}