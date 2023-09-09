import kotlin.math.max

fun main() {
    val numberOfLine = readln().toInt()

    var count = 0
    var mx = 0
    buildList {
        repeat(numberOfLine) {
            val (start, end) = readln().split(" ").map { it.toInt() }.toLine().gradient
            add(start to 1)
            add(end to -1)
        }
    }.sortedWith(compareBy({ it.first }, { -it.second })).forEach {
        count += it.second
        mx = max(mx, count)
    }
    println(mx)
}

class Line(p1: Point, p2: Point) {
    val gradient: Pair<Double, Double>

    init {
        val g1 = p1.y.toDouble() / p1.x
        val g2 = p2.y.toDouble() / p2.x
        gradient = if (g1 < g2)
            g1 to g2
        else
            g2 to g1
    }
}

fun List<Int>.toLine(): Line {
    val (x1, y1, x2, y2) = this
    return Line(Point(x1, y1), Point(x2, y2))
}

data class Point(val x: Int, val y: Int)
