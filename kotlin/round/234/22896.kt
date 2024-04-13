import kotlin.math.max

fun main() {
    repeat(readln().toInt()) {
        val maxTicket = readln().split(" ")[1].toInt()
        val tickets = readln().split(" ").map { it.toInt() }.toSortedSet()

        val first = tickets.first() - 1
        val last = maxTicket - tickets.last()
        val centerDiff = tickets.windowed(2).map { it[1] - it[0] }
        val center = centerDiff.map { it / 2 }

        println("Case #${it + 1}: ${
            (if (center.isNotEmpty()) {
                (center + first + last).sortedDescending().let { sortedList ->
                    (max(sortedList[0] + sortedList[1], centerDiff.maxOf { it } - 1))
                }
            } else {
                (first + last)
            }).toDouble() / maxTicket
        }")
    }
}