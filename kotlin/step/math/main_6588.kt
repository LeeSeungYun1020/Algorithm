import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main() {
    val input = mutableListOf<Int>()
    var max = 0
    while (true) {
        val num = readLine()!!.toInt()
        if (num == 0)
            break
        if (max < num)
            max = num
        input.add(num)
    }

    val prime = MutableList(max + 1) { true }
    for (i in 2..max) {
        if (prime[i]) {
            for (j in (i..(max/i))) {
                prime[i * j] = false
            }
        }
    }

    for (num in input) {
        for (i in 2..num) {
            val compare = num - i
            if (compare < i) {
                println("Goldbach's conjecture is wrong.")
                break
            }
            if (prime[i] && prime[compare]) {
                println("$num = $i + $compare")
                break
            }
        }
    }
}