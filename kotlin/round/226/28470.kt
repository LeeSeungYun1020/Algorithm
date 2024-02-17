import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val attack = readln().split(" ").map { it.toInt() }
    val defence = readln().split(" ").map { -it.toInt() }
    val k = readln().split(" ").map { it.replace(".", "").toInt() }

    var sum = 0L
    for (i in 0 until n) {
        sum += max(k[i] * attack[i] / 10 + defence[i], k[i] * defence[i] / 10 + attack[i])
    }
    println(sum)
}