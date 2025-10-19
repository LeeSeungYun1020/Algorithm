import kotlin.math.absoluteValue

fun main() {
    val (num, height, width) = readln().split(" ").map { it.toInt() }
    val points = List(num) { readln().split(" ").map { it.toInt() }.toPoint() }
    var answer = 0
    for (p1 in points) {
        for (p2 in points) {
            if ((p1.x - p2.x).absoluteValue < height && (p1.y - p2.y).absoluteValue < width) {
                answer = answer.coerceAtLeast((p1.value - p2.value).absoluteValue)
            }
        }
    }
    println(answer)
}

data class Point(val x: Int, val y: Int, val value: Int)

fun List<Int>.toPoint() = Point(this[0], this[1], this[2])