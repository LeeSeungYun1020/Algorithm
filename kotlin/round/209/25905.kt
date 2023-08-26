fun main() {
    val percentage = List(10) { readln().toDouble() }
    println((percentage - percentage.minOf { it }).foldIndexed(10e8.toDouble()) { index, acc, d -> acc * d / (index + 1) })
}