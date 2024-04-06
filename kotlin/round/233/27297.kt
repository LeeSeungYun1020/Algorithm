import kotlin.math.absoluteValue

fun main() {
    val (matrix, numberOfPoint) = readln().split(" ").map { it.toInt() }
    val points = List(numberOfPoint) { readln().split(" ").map { it.toLong() } }
    val center = List(matrix) { i -> points.map { it[i] }.sorted().run { get(size / 2) } }
    var distance = 0L
    center.forEachIndexed { index, p ->
        distance += points.sumOf { (it[index] - p).absoluteValue }
    }
    println(distance)
    println(center.joinToString(separator = " "))
}