import kotlin.math.min

fun main() {
    val count = readLine()!!.toInt()
    val ring = readLine()!!.split(' ').map { it.toInt() }
    for (i in 1 until count){
        var std = ring[0]
        var cmp = ring[i]
        var j = 2
        while (j <= min(std, cmp)){
            if (std % j == 0 && cmp % j == 0){
                std /= j
                cmp /= j
            } else j++
        }
        println("$std/$cmp")
    }
}