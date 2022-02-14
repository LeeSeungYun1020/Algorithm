fun main() {
    val count = readLine()!!.toInt()
    for (i in 1..count) {
        println("Case #${i}: ${readLine()!!.split(' ').map { s -> s.toInt() }.sum()}")
    }
}