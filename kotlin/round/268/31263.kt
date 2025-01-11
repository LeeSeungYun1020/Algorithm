fun main() {
    readln()
    val paper = readln()
    var i = paper.lastIndex
    var count = 0
    while (i >= 0) {
        val a = paper.getOrNull(i - 2)?.digitToInt() ?: 0
        val b = paper.getOrNull(i - 1)?.digitToInt() ?: 0
        val c = paper.getOrNull(i)?.digitToInt() ?: 0
        i -= checker(a, b, c)
        count++
    }
    println(count)
}

fun checker(a: Int, b: Int, c: Int): Int {
    return when {
        a == 6 -> {
            when {
                b == 4 && c <= 1 -> 3
                b < 4 -> 3
                else -> 2
            }
        }
        a in 1..5 -> 3
        b in 1..9 -> 2
        else -> 1
    }
}