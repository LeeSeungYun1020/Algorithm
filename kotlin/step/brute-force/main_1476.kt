fun main() {
    val (E, S, M) = readLine()!!.split(" ").map { it.toInt() - 1 }
    for (i in 0 until 15 * 28 * 19) {
        if (E == i % 15 && S == i % 28 && M == i % 19) {
            println(i + 1)
            return
        }
    }
}