import kotlin.math.ceil

fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toDouble() }
    print(ceil((c-a)/(a-b)).toInt() + 1)
}