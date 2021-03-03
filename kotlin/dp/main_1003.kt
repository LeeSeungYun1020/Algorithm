fun main() {
    val count = readLine()!!.toInt()
    val fib = Array<Pair<Int, Int>>(41) { 0 to 0 }
    fib[0] = 1 to 0
    fib[1] = 0 to 1
    for (i in 2..40) {
        fib[i] = fib[i - 2] + fib[i - 1]
    }
    for (i in 1..count) {
        val pair = fib[readLine()!!.toInt()]
        println("${pair.first} ${pair.second}")
    }
}

private operator fun Pair<Int, Int>.plus(pair: Pair<Int, Int>): Pair<Int, Int> = (this.first + pair.first) to (this.second + pair.second)
