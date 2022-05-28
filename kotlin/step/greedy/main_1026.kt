fun main() {
    val n = readln().toInt()
    val listA = readln().split(" ").map { it.toInt() }.sorted()
    val listB = readln().split(" ").map { it.toInt() }.sortedDescending()
    println((0 until n).sumOf { listA[it] * listB[it] })
}