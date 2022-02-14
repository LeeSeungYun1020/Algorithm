fun main() {
    val count = readLine()!!.toInt()

    for (i in 1..count)
        println("*".repeat(i).padStart(count, ' '))
}