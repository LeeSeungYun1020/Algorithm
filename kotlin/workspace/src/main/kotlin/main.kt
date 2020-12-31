fun main() {
    val count = readLine()!!.toInt()

    if (count == 1) {
        println("*")
        return
    }
    
    println("*".padStart(count))
    for (i in 1..(count-2))
        println("*".padStart(count - i).padEnd(count + i - 1) + "*")
    println("*".repeat(count * 2 - 1))
}