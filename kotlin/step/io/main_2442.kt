fun main() {
    val count = readLine()!!.toInt()

    for (i in 1..count)
        println("*".repeat(2 * i - 1).padStart(count + i - 1, ' '))
}