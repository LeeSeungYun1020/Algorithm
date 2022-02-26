fun Int.factorial(): Int {
    if (this <= 1) return 1
    return (1..this).reduce { a, b -> a * b }
}

fun count(one: Int, two: Int, three: Int): Int {
    return (one + two + three).factorial() / one.factorial() / two.factorial() / three.factorial()
}

fun main() {
    val n = readLine()!!.toInt()
    val input = List(n) { readLine()!!.toInt() }
    for (num in input) {
        var sum = 0
        for (i in num downTo 0) {
            for (j in 0..num/2) {
                for (k in 0..num/3) {
                    val compare = i + j * 2 + k * 3
                    if (compare > num) {
                        break
                    }
                    if (compare == num) {
                        sum += count(i, j, k)
                        break
                    }
                }
            }
        }
        println(sum)
    }
}