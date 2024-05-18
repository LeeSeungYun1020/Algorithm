import kotlin.math.max
import kotlin.math.min

fun main() {
    val plannedLines = List<Line>(readln().toInt()) {
        val (start, end, cost) = readln().split(' ').map { it.toInt() }
        Line(start, end, cost)
    }.sortedBy { it.start }

    val lines = mutableListOf<Line>()
    var prevStart = plannedLines.first().start
    var prevEnd = plannedLines.first().end
    var prevCost = plannedLines.first().cost
    for (line in plannedLines) {
        when {
            line.start <= prevEnd -> {
                prevEnd = max(prevEnd, line.end)
                prevCost = min(prevCost, line.cost)
            }

            else -> {
                if (prevStart != -1) lines.add(Line(prevStart, prevEnd, prevCost))
                prevStart = line.start
                prevEnd = line.end
                prevCost = line.cost
            }
        }
    }
    lines.add(Line(prevStart, prevEnd, prevCost))
    println(lines.size)
    println(lines.joinToString("\n") { "${it.start} ${it.end} ${it.cost}" })
}

class Line(val start: Int, val end: Int, val cost: Int)