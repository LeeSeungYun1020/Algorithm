fun main() {
    val num = readLine()!!.toInt()
    println((1..num).sumOf { it.toLong() * (num / it) })
}