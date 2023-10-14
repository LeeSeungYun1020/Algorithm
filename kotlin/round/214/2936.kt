import kotlin.math.roundToInt

const val HALF = 250.0 * 250.0 / 2.0
fun main() {
    val point = readln().toPoint()

    println(
        when {
            point.a == 0.0 -> {
                when (point.b) {
                    125.0 -> Point(250.0, 0.0)
                    in 125.0..250.0 -> case1(point)
                    else -> case2(point)
                }
            }
            point.b == 0.0 -> {
                when (point.a) {
                    125.0 -> Point(0.0, 250.0)
                    in 0.0..125.0 -> case3(point)
                    else -> case4(point)
                }
            }
            else -> {
                when (point.a) {
                    125.0 -> Point(0.0, 0.0)
                    in 125.0..250.0 -> case5(point)
                    else -> case6(point)
                }
            }
        }
    )
}

fun case1(point: Point): Point {
    return Point(HALF / point.b, 0.0)
}

fun case2(point: Point): Point {
    val h = HALF / (250.0 - point.b)
    return Point(h, slope(h))
}

fun case3(point: Point): Point {
    val h = HALF / (250 - point.a)
    return Point(slope(h), h)
}

fun case4(point: Point): Point {
    return Point(0.0, HALF / point.a)
}

fun case5(point: Point): Point {
    return Point(0.0, (HALF - 250 * point.b) / point.a)
}

fun case6(point: Point): Point {
    return Point(250.0 - HALF / point.b, 0.0)
}

data class Point(val a: Double, val b: Double) {
    override fun toString(): String {
        return "${"%.2f".format(a.round())} ${"%.2f".format(b.round())}"
    }
}

fun String.toPoint() = this.split(" ").map { it.toDouble() }.let {
    Point(it[0], it[1])
}

fun Double.round(): Double {
    return (this * 100).roundToInt() / 100.0
}

fun slope(x: Double) = -x + 250