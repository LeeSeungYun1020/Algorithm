fun main() {
    var (_, heart) = readln().split(" ").map { it.toInt() }
    val attack = readln().split(" ").map { it.toInt() }

    for (i in attack.indices) {
        heart -= attack[i]
        if (heart <= 0) {
            println(i + 1)
            return
        }
    }
    println(-1)
}