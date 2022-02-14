fun main() {
    val input = listOf(readLine()!!.split(' '), readLine()!!.split(' '), readLine()!!.split(' '))
    val x = input.map { it.first() }.groupingBy { it }.eachCount().minByOrNull { it.value }!!.key
    val y = input.map { it.last() }.groupingBy { it }.eachCount().minByOrNull { it.value }!!.key
    println("$x $y")
}