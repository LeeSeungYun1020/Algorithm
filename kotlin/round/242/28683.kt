import kotlin.math.roundToLong
import kotlin.math.sqrt

fun main() {
    val n = readln().toLong()

    val root = sqrt(n.toDouble())
    val roundRoot = root.roundToLong()
    if (roundRoot * roundRoot == n) {
        println(-1)
        return
    }

    var count = 0
    // n = a^2 + b^2
    for (a in 1..sqrt(n.toDouble() / 2).toLong()) {
        val bsq = n - a * a
        val b = sqrt(bsq.toDouble()).roundToLong()
        if (b * b == bsq) {
            count++
        }
    }
    // n = c^2 - b^2 = (c + b)(c - b)
    for (cmb in 1..root.toLong()) {
        if (n % cmb == 0L) {
            val cpb = n / cmb
            if ((cmb + cpb) % 2 == 0L) count++
        }
    }
    println(count)
}

