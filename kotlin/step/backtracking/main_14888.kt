import kotlin.math.max
import kotlin.math.min

lateinit var num: IntArray
lateinit var operation: IntArray
var n = 0
var minValue = 10_0000_0000
var maxValue = -10_0000_0000

fun main() {
    n = readLine()!!.toInt()
    num = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    operation = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    calc(1, num[0])
    println(maxValue)
    println(minValue)
}

fun calc(depth: Int, value: Int) {
    if (depth == n) {
        minValue = min(minValue, value)
        maxValue = max(maxValue, value)
    } else {
        for (i in 0..3){
            if (operation[i] > 0) {
                operation[i]--
                calc(depth + 1, when(i) {
                    0 -> value + num[depth]
                    1 -> value - num[depth]
                    2 -> value * num[depth]
                    else -> value / num[depth]
                })
                operation[i]++
            }
        }
    }
}