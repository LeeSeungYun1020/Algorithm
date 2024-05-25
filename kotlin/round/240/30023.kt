import kotlin.math.min

fun main() {
    readln()
    val origin = readln().map {
        when (it) {
            'R' -> 0
            'G' -> 1
            'B' -> 2
            else -> error("RGB input")
        }
    }

    fun countSteps(start: Int, maxStep: Int): Int {
        val state = origin.toMutableList()
        var count = 0
        while (state.first() != start) {
            count++
            state.change(0)
        }
        for (i in 1..state.lastIndex - 2) {
            while (state[i] != start) {
                count++
                state.change(i)
            }
            if (count >= maxStep) {
                return Int.MAX_VALUE
            }
        }
        if (start == state.last() && start == state[state.lastIndex - 1]) return count
        else return Int.MAX_VALUE
    }

    var answer = Int.MAX_VALUE
    for (i in 0..2) {
        answer = min(answer, countSteps(i, answer))
    }
    println(if (answer == Int.MAX_VALUE) -1 else answer)
}

fun MutableList<Int>.change(start: Int) {
    for (i in start..start + 2) {
        this[i] = (this[i] + 1) % 3
    }
}