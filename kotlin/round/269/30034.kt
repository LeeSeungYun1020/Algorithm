fun main() {
    readln()
    val letters = readln().split(" ").toMutableSet()
    readln()
    val numbers = readln().split(" ").toMutableSet()
    readln()
    val mergers = readln().split(" ").toSet()

    letters.removeAll(mergers)
    numbers.removeAll(mergers)

    readln()
    readln().split(*"$letters$numbers ".toCharArray())
        .filter { it.isNotEmpty() }
        .joinToString(separator = "\n")
        .run { println(this) }
}