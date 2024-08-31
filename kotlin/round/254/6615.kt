fun main() {
    val answer = StringBuilder()
    while (true) {
        val (a, b) = readln().split(" ").map { it.toLong() }
        val map = mutableMapOf<Long, Int>()
        if (a == 0L) break

        var step = 1
        var t = a
        map[t] = 0
        while (t != 1L) {
            t = transform(t)
            map[t] = step++
        }

        t = b
        var stepB = 0
        while (map[t] == null) {
            t = transform(t)
            stepB++
        }
        val stepA = map[t]

        answer.append("$a needs $stepA steps, $b needs $stepB steps, they meet at ${t}\n")
    }
    println(answer)
}

fun transform(x: Long): Long {
    return if (x % 2L == 0L) x / 2 else 3 * x + 1
}