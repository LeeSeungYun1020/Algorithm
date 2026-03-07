fun main() {
    repeat(readln().toInt()) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        when {
            x >= 0 && y == 0 -> 0
            x >= 0 -> 1
            x >= y -> 1
            y == 0 -> 1
            else -> 2
        }.run(::println)
    }
}