import kotlin.system.exitProcess

fun main() {
    val (numberOfFixedTime, numberOfTask) = readln().split(" ").map { it.toInt() }
    val fixedTimes = List(numberOfFixedTime) { readln().split(" ").map { it.toInt() } }
    val tasks = readln().split(" ").map { it.toInt() }.sortedDescending()

    val leftTimes = mutableListOf<Int>()
    var prev = 0
    fixedTimes.forEach { (start, end) ->
        if (start != 0 && start - prev >= tasks.last()) leftTimes.add(start - prev)
        prev = end
    }
    if (prev != 1440 && 1440 - prev >= tasks.last()) leftTimes.add(1440 - prev)
    leftTimes.sort()

    if (leftTimes.sum() < tasks.sum()) {
        println("BAD")
        return
    }

    fun check(left: MutableList<Int>, target: Int): Boolean {
        if (target >= numberOfTask) {
            println("GOOD")
            exitProcess(0)
        }

        for (i in left.indices) {
            if (left[i] >= tasks[target]) {
                left[i] -= tasks[target]
                check(left, target + 1)
                left[i] += tasks[target]
            }
        }
        return false
    }

    check(leftTimes, 0)
    println("BAD")

}