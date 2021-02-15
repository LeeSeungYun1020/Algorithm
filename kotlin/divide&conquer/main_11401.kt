const val standard = 1_000_000_007

fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    when (k) {
        0 -> {
            println(1)
        }
        1 -> {
            println(n)
        }
        else -> {
            val factorial = IntArray(n + 1) { it }
            for (i in 3..n) {
                factorial[i] = ((factorial[i].toLong() * factorial[i - 1]) % standard).toInt()
            }
            println((factorial[n].toLong() * factorial[k].pow(standard - 2) % standard) * factorial[n - k].pow(standard - 2) % standard)
        }
    }
}

fun Int.pow(k: Int): Int {
    if (k == 1)
        return this
    val tem = (this.toLong() * this % standard).toInt().pow(k/2)
    return if (k % 2 == 0)
        tem
    else
        (tem.toLong() * this % standard).toInt()
}