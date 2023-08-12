fun main() {
    val info = readln().split(" ")
    List(size = info[1].toInt()) {
        readln().split(" ").map { it.toMirrorNumber() }
    }.displayWithMirror(direction = info[0].toDirection())
}

enum class Direction {
    UD, LR
}

fun String.toDirection() = when (this) {
    "L" -> Direction.LR
    "R" -> Direction.LR
    "U" -> Direction.UD
    "D" -> Direction.UD
    else -> throw Exception("Input Error")
}


fun String.toMirrorNumber() = when (this) {
    "2" -> "5"
    "5" -> "2"
    "1", "8" -> this
    else -> "?"
}

fun List<List<String>>.displayWithMirror(direction: Direction) {
    var iRange: IntProgression = 0..this.lastIndex
    var jRange: IntProgression = 0..this[0].lastIndex
    when (direction) {
        Direction.LR -> {
            jRange = this[0].lastIndex downTo 0
        }
        Direction.UD -> {
            iRange = this.lastIndex downTo 0
        }
    }
    for (i in iRange) {
        for (j in jRange) {
            print("${this[i][j]} ")
        }
        println()
    }
}