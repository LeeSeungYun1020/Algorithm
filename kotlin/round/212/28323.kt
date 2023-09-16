import kotlin.math.max

fun main() {
    //val n = readln().toInt()
    readln()
    val numbers = readln().split(" ").map { it.toInt() }

    val evenStarter = Starter(0, false)
    val oddStarter = Starter(0, true)
    for (num in numbers) {
        if (num % 2 == 0) {
            if (!evenStarter.isEven)
                evenStarter.apply {
                    count++
                    isEven = true
                }
            if (!oddStarter.isEven)
                oddStarter.apply {
                    count++
                    isEven = true
                }
        } else {
            if (evenStarter.isEven)
                evenStarter.apply {
                    count++
                    isEven = false
                }
            if (oddStarter.isEven)
                oddStarter.apply {
                    count++
                    isEven = false
                }
        }
    }
    println(max(evenStarter.count, oddStarter.count))
}

class Starter(var count: Int, var isEven: Boolean)