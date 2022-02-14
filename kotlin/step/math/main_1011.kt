import kotlin.math.ceil
import kotlin.math.sqrt

fun main() {
    val lines = readLine()!!.split("\n")
    for (line in lines.subList(1, lines.lastIndex + 1)){
        val (x, y) = line.split(" ").map { it.toDouble() }
        val distance = y - x
        var even = ceil(sqrt(4 * distance + 1) - 1).toInt()
        var odd = ceil(2 * sqrt(distance) - 1).toInt()
        if (even % 2 != 0)
            even++
        if (odd % 2 == 0)
            odd++
        println(if(even>odd) odd else even)
    }
}