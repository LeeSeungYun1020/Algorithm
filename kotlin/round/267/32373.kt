fun main() {
    val (_, distance) = readln().split(" ").map { it.toInt() }
    readln().split(" ").forEachIndexed { index, s ->
        if (s.toInt() % distance != index % distance) {
            println("No")
            return
        }
    }
    println("Yes")
}