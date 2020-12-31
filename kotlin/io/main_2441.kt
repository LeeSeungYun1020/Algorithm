fun main() {
    val count = readLine()!!.toInt()

    for (i in count.downTo(1))
        println("*".repeat(i).padStart(count, ' '))
}

// .padEnd(count, ' ')