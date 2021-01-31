import kotlin.math.min

fun main() {
    val input = readLine()!!.split('\n')
    val budget = input[1].split(' ').map { it.toInt() }
    val total = input[2].toInt()

    if (budget.sum() <= total){
        println(budget.maxOrNull())
        return
    }

    var max = budget.maxOrNull()!!
    var min = 1

    var ans = 0
    while (min <= max) {
        val mean = (max + min) / 2
        if (budget.sumOf { min(it, mean).toLong() } <= total) {
            ans = mean
            min = mean + 1
        } else {
            max = mean - 1
        }
    }
    println(ans)
}