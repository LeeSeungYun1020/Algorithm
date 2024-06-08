import java.util.*

fun main() {
    val box = readln().toInt()
    val candies = readln().split(" ").map { it.toInt() }.toCollection(PriorityQueue<Int>())

    if (box < 2) {
        onFail()
        return
    }

    var bags = 0
    while (candies.isNotEmpty()) {
        val first = candies.poll()
        val second = candies.poll()
        if (first == second) {
            candies.add(first + 1)
        } else {
            bags++
            if (second != null) candies.add(second)
            if (bags > 2) {
                onFail()
                return
            }
        }
    }
    onSuccess()
}

fun onFail() {
    println("N")
}

fun onSuccess() {
    println("Y")
}
