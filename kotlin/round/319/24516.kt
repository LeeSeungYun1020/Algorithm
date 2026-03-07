fun main() {
    generateSequence(1) { it + 2 }
        .take(readln().toInt())
        .joinToString(separator = " ")
        .run(::println)
}