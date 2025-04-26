fun main() {
    val (_, numberOfShots, standard) = readln().split(" ").map { it.toInt() }
    val points = readln().split(" ").map { it.toInt() }.sorted()

    findLeast(points.first(), points.last()) {
        calc(points, it, numberOfShots) >= standard
    }.run { println(this) }
}

fun findLeast(start: Int, end: Int, comp: (target: Int) -> Boolean): Int {
    if (start > end) return -1

    val target = (start + end) / 2
    if (comp(target)) {
        val next = findLeast(start, target - 1, comp)
        return if (next != -1) next else target
    } else {
        return findLeast(target + 1, end, comp)
    }
}

fun calc(points: List<Int>, start: Int, left: Int): Long {
    var i = 0
    var point = 0L
    repeat(left) {
        while (i < points.lastIndex && points[i + 1] <= point + start) i++
        point += points[i]
    }
    return point
}