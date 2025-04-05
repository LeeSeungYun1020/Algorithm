fun main() {
    fun List<Int>.toIsOddMap() = groupBy { it }.mapValues { it.value.size % 2 == 1 }
    fun Map<Int, Boolean>.crossCheck(other: Map<Int, Boolean>): Boolean {
        (keys + other.keys).forEach { if ((this[it] == true) != (other[it] == true)) return false }
        return true
    }

    val (currentRed, targetRed) = readln().split(" ").map { it.toInt() }
    val (currentX, currentY) = List(currentRed) { readln().split(" ").map { it.toInt() } }
        .run { map { it[0] }.toIsOddMap() to map { it[1] }.toIsOddMap() }
    val (targetX, targetY) = List(targetRed) { readln().split(" ").map { it.toInt() } }
        .run { map { it[0] }.toIsOddMap() to map { it[1] }.toIsOddMap() }

    if (currentX.crossCheck(targetX) && currentY.crossCheck(targetY)) {
        println("YES")
    } else {
        println("NO")
    }
}