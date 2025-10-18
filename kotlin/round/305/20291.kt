fun main() {
    List(readln().toInt()) { readln().split(".") }
        .groupingBy { it[1] }
        .eachCount()
        .toSortedMap()
        .entries
        .joinToString(separator = "\n") { "${it.key} ${it.value}" }
        .run(::print)
}