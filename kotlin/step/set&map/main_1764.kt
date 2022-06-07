fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val listen = List(n) { readln() }.associateWith { true }
    val see = mutableListOf<String>()
    for (i in 1..m) {
        val look = readln()
        if (listen[look] == true)
            see.add(look)
    }
    println(see.count())
    see.sorted().forEach { println(it) }
}
