import kotlin.math.absoluteValue

fun main() {
    readln()
    readln()
        .split(" ")
        .map { it.toInt() }
        .zip(readln().split(" ").map { it.toInt() })
        .map { it.first - it.second }
        .toMutableList()
        .let { diff ->
            diff.slice(0..diff.lastIndex - 2).sumOf { it.absoluteValue } +
                    (diff.last() - diff[diff.lastIndex - 1]).absoluteValue
        }.run { println(this) }
}