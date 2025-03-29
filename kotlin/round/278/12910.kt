fun main() {
    val n = readln().toInt()
    val candies = readln().split(" ").map { it.toInt() - 1 }.groupingBy { it }.eachCount()

    (1..n).sumOf { lastBrand ->
        (0 until lastBrand).fold(1L) { acc, i -> acc * (candies[i] ?: 0) }
    }.let { println(it) }
}