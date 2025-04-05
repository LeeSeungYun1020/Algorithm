fun main() {
    readln()
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }
    val c = readln().split(" ").map { it.toInt() }

    var current = -1
    for (i in a.indices) {
        val (mn, _, mx) = listOf(a[i], b[i], c[i]).sorted()
        when {
            current < mn -> current = mn
            current < mx -> current++
            else -> {
                println("NO")
                return
            }
        }
    }
    println("YES")
}