import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val input = readLine()!!.split("\n")
    val count = input[0].toInt()
    for (i in 1..count){
        val list = input[i].split(' ').map { it.toDouble() }
        val abLen = sqrt((list[3] - list[0]).pow(2) + (list[4] - list[1]).pow(2))
        println(when {
            abLen == 0.0 -> {
                if (list[2] == list[5])
                    -1
                else
                    0
            }
            abLen > list[2] + list[5] || abLen < (list[2] - list[5]).absoluteValue -> 0
            abLen == list[2] + list[5] || abLen == (list[2] - list[5]).absoluteValue -> 1
            else -> 2
        })
    }
}