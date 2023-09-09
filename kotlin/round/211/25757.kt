fun main() {
    val (n, type) = readln().split(" ").map {
        it.toIntOrNull() ?: when (it) {
            "Y" -> 1
            "F" -> 2
            else -> 3
        }
    }
    val people = List(n) { readln() }.distinct().size
    println(people / type)
}