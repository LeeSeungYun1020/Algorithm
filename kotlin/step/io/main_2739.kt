fun main() {
    val input = getInt()
    for (i in 1..9)
        println("$input * $i = ${input*i}")
}

fun getInt() = readLine()?.toInt() ?: 0