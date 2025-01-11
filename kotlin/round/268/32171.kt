fun main() {
    var xMin = Int.MAX_VALUE
    var yMin = Int.MAX_VALUE
    var xMax = Int.MIN_VALUE
    var yMax = Int.MIN_VALUE
    repeat(readln().toInt()) {
        val (a, b, c, d) = readln().split(' ').map { it.toInt() }
        xMin = minOf(a, c, xMin)
        xMax = maxOf(a, c, xMax)
        yMin = minOf(b, d, yMin)
        yMax = maxOf(b, d, yMax)
        println((xMax - xMin + yMax - yMin) * 2)
    }
}