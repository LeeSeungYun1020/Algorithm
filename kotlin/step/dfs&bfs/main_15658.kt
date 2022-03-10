import kotlin.math.max
import kotlin.math.min

data class State(val idx: Int, val sum: Int, val p: Int, val m: Int, val t: Int, val d: Int)

fun main() {
    val n = readln().toInt()
    val number = readln().split(" ").map { it.toInt() }
    val (plus, minus, times, div) = readln().split(" ").map { it.toInt() }

    val deque = ArrayDeque<State>()
    deque.add(State(1, number[0], plus, minus, times, div))
    var mn = Int.MAX_VALUE
    var mx = Int.MIN_VALUE
    while (deque.isNotEmpty()) {
        val (idx, sum, p, m, t, d) = deque.removeFirst()
        if (idx == n) {
            mn = min(mn, sum)
            mx = max(mx, sum)
        } else {
            if (p > 0)
                deque.add(State(idx+1, sum+number[idx], p - 1, m, t, d))
            if (m > 0)
                deque.add(State(idx+1, sum-number[idx], p, m - 1, t, d))
            if (t > 0)
                deque.add(State(idx+1, sum*number[idx], p, m, t - 1, d))
            if (d > 0)
                deque.add(State(idx+1, sum/number[idx], p, m, t, d - 1))
        }
    }
    println(mx)
    println(mn)
}