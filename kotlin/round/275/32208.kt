fun main() {
    buildString {
        repeat(readln().toInt()) {
            append(
                readln().split(" ")
                    .sumOf { it.toLong() }
                    .takeIf { it % 2 == 0L }
                    ?.let { "YES\n" }
                    ?: "NO\n"
            )
        }
    }.run { println(this) }
}
