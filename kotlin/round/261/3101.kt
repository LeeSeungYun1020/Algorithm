fun main() {
    val (size, _) = readln().split(" ").map { it.toInt() }
    val line = List(size * 2 - 2) {
        if (it < size) it + 1L else size * 2L - it - 1
    }.runningFold(1L) { acc, i -> acc + i }

    var answer = 1L
    var x = 0
    var y = 0
    readln().forEach {
        when (it) {
            'U' -> x--
            'D' -> x++
            'L' -> y--
            'R' -> y++
        }
        val sum = x + y
        val start = line[sum]
        answer += if (sum % 2 == 0) {
            if (sum < size) start + y else start - x + size - 1
        } else {
            if (sum < size) start + x else start - y + size - 1
        }
    }
    println(answer)
}