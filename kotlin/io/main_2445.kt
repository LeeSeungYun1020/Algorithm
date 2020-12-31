fun main() {
    val count = readLine()!!.toInt()

    for (i in 1..count)
        println("*".repeat(i).padEnd(count * 2 - i, ' ') + "*".repeat(i))
    for (i in (count-1).downTo(1))
        println("*".repeat(i).padEnd(count * 2 - i, ' ') + "*".repeat(i))
}