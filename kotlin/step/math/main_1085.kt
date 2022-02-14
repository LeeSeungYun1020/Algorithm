import kotlin.math.min

fun main() {
    val (x, y, w, h) = readLine()!!.split(' ').map{ it.toInt() }
    println(min(min(x, y), min(w - x, h - y)))
}