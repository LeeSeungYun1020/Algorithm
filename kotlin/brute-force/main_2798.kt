import kotlin.math.absoluteValue

fun main() {
    val (_, m) = readLine()!!.split(' ').map { it.toInt() }
    val list = readLine()!!.split(' ').map { it.toInt() }

    var ans = 0
    for (i in 0..list.lastIndex - 2) {
        for (j in i+1 until list.lastIndex) {
            for (k in j+1 .. list.lastIndex) {
                val cmp = list[i] + list[j] + list[k]
                if (cmp <= m && (cmp - m).absoluteValue < (ans - m).absoluteValue)
                    ans = cmp
            }
        }
    }
    println(ans)
}