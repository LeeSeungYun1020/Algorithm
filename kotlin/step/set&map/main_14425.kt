fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = List(n) { readln() }.associateWith { true }
    var count = 0
    for (i in 1..m) {
        if (map[readln()] == true)
            count++
    }
    println(count)
}
