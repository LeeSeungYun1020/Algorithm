fun main() {
    val count = readLine()!!.toInt()

    for (i in 1.until(count))
        println("*".repeat(i).padStart(count, ' '))
    for (i in count.downTo(1))
        println("*".repeat(i).padStart(count, ' '))
}