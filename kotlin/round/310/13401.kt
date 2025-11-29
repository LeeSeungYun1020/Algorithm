import kotlin.math.max
import kotlin.math.min

fun main() {
    val (numberOfLanes, numberOfArms) = readln().split(" ").map { it.toInt() }
    val L = MutableList(numberOfLanes) { it }
    val R = MutableList(numberOfLanes) { it }
    List(numberOfArms) { readln().split(" ").map { it.toInt() } }.sortedBy { it[0] }.forEach { (_, pos) ->
        val left = pos - 1
        val right = pos
        val newL = min(L[left], L[right])
        val newR = max(R[left], R[right])
        L[left] = newL
        R[left] = newR
        L[right] = newL
        R[right] = newR
    }
    R.zip(L).joinToString(" ") { "${it.first - it.second + 1}" }.run(::println)
}