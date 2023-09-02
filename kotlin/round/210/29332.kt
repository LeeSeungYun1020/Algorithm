fun main() {
    val n = readln().toInt()
    List(n) { readln().split(" ").toLocation() }.groupBy { it.direction }.mapValues { (key, value) ->
        when (key) {
            Direction.LEFT, Direction.DOWN -> value.minOfOrNull { it.limit }
            Direction.RIGHT, Direction.UP -> value.maxOfOrNull { it.limit }
        }
    }.toLimit().printResult()
}

class Limit(private val left: Int?, private val right: Int?, private val up: Int?, private val down: Int?) {
    fun printResult() {
        if (left != null && right != null && up != null && down != null) {
            println((left - right - 1).toLong() * (down - up - 1))
        } else {
            println("Infinity")
        }
    }
}

fun Map<Direction, Int?>.toLimit() =
    Limit(this[Direction.LEFT], this[Direction.RIGHT], this[Direction.UP], this[Direction.DOWN])

data class Location(
    val x: Int,
    val y: Int,
    val direction: Direction,
) {
    val limit: Int
        get() = when (direction) {
            Direction.LEFT, Direction.RIGHT -> x
            else -> y
        }
}

fun List<String>.toLocation() = Location(this[0].toInt(), this[1].toInt(), this[2].toDirection())

enum class Direction {
    LEFT, RIGHT, UP, DOWN
}

fun String.toDirection() = when (this) {
    "L" -> Direction.LEFT
    "R" -> Direction.RIGHT
    "U" -> Direction.UP
    else -> Direction.DOWN
}