fun main() {
    val count = readLine()!!.toInt()

    for (i in count.downTo(1))
        println("*".repeat(2 * i - 1).padStart(count + i - 1, ' '))
    for (i in 2..count)
        println("*".repeat(2 * i - 1).padStart(count + i - 1, ' '))
}