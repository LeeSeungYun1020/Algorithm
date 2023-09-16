fun main() {
    val (oSize, tSize) = readln().split(" ").map { it.toInt() }
    val original = readln().split(" ").map { it.toInt() }
    val target = readln().split(" ").map { it.toInt() }

    var count = 0
    for (i in 0 until tSize) {
        if (original[i] !in target)
            count++
    }
    println(count)
}