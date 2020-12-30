fun main() {
    val count = readLine()!!.toInt()
    for (i in 1..count) {
        println(readLine()!!.split(',').map { s -> s.toInt() }.sum())
    }
}