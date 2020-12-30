fun main() {
    val input = readLine()!!.split("\n", " ").map { it.toInt() }
    for (i in 0.until(input[0])){
        println(input[1 + 2 * i] + input[2 + 2 * i])
    }
}