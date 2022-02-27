fun gcd(a: Int, b: Int): Int {
    val (x, y) = if (a > b) a to b else b to a
    if (y == 1) return 1
    if (y == 0) return x
    return gcd(x % y, y)
}

fun main() {
    val t = readLine()!!.toInt()
    label@
    for (r in 1..t) {
        val (m, n, x, y) = readLine()!!.split(" ").map { it.toInt() }
        val mx = m / gcd(m, n) * n
        var target = x
        while (target <= mx) {
            if (target % n == y % n) {
                println(target)
                continue@label
            }
            target += m
        }
        println(-1)
    }
}