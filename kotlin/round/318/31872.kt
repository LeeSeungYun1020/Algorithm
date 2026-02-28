import kotlin.math.absoluteValue

fun main() {
    val (_, numberOfTeleports) = readln().split(" ").map { it.toInt() }
    (readln().split(" ").map { it.toInt() } + 0)
        .asSequence()
        .sorted()
        .windowed(2) { (a, b) -> (a - b).absoluteValue }
        .sortedDescending()
        .drop(numberOfTeleports)
        .sum()
        .run { print(this) }
}