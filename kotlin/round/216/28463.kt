fun main() {
    val direction = readln().toDirection()
    println(List(2) { readln() }.toJump(direction))
}

enum class Direction {
    EAST, WEST, SOUTH, NORTH
}

fun String.toDirection(): Direction {
    return when (this) {
        "E" -> Direction.EAST
        "W" -> Direction.WEST
        "S" -> Direction.SOUTH
        else -> Direction.NORTH
    }
}

fun List<String>.rotateToRight(): List<String> {
    return listOf("${this[0][1]}${this[1][1]}", "${this[0][0]}${this[1][0]}")
}

val southT = listOf(".O", "P.")
val southF = listOf("I.", ".P")
val southL = listOf("O.", ".P")
fun casesByDirection(direction: Direction): List<List<String>> {
    var cases = listOf(southT, southF, southL)
    if (direction == Direction.SOUTH)
        return cases
    cases = cases.map { it.rotateToRight() }

    if (direction == Direction.EAST)
        return cases
    cases = cases.map { it.rotateToRight() }

    if (direction == Direction.NORTH)
        return cases
    cases = cases.map { it.rotateToRight() }
    return cases
}

fun List<String>.toJump(direction: Direction): String {
    val cases = casesByDirection(direction)
    return when (this) {
        cases[0] -> "T"
        cases[1] -> "F"
        cases[2] -> "Lz"
        else -> "?"
    }
}