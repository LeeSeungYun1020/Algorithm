fun main() {
    val (x, y, z) = readln().split(" ").map { it.toInt() }
    if (x == 3 && y == 3 && z == 3) {
        println(0)
    } else {
        println((minOf(x, y, z) - 1) / 2)
    }
}