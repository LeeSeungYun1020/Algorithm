fun main() {
    readLine()
    val div = readLine()!!.split(' ').map { it.toInt() }
    println((div.minOrNull()?:0) * (div.maxOrNull()?:0))
}