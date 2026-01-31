fun main() {
    val (_, n) = readln().split(" ").map { it.toInt() }
    println("YES")
    List(n) { readln().split(" ").map { it.toInt() }[1] }.asSequence().withIndex()
        .sortedBy { it.value }
        .mapIndexed { index, origin -> index + 1 to origin.index }
        .sortedBy { it.second }
        .map { it.first }
        .joinToString(separator = " ")
        .let { println(it) }
}