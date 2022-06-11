import kotlin.math.pow

fun main() {
    val (w, h, x, y, p) = readln().split(" ").map { it.toInt() }
    val r = h / 2
    var count = 0
    for (i in 1..p) {
        val (px, py) = readln().split(" ").map { it.toInt() }
        if (px in x..x + w && py in y..y + h)
            count++
        else if (px in x - r..x && py in y..y + h
            && (px - x).toDouble().pow(2) + (py - y - r).toDouble().pow(2) <= r.toDouble().pow(2)
        )
            count++
        else if (px in x + w..x + w + r && py in y..y + h
            && (px - x - w).toDouble().pow(2) + (py - y - r).toDouble().pow(2) <= r.toDouble().pow(2)
        )
            count++
    }
    println(count)
}