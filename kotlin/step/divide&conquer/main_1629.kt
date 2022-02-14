fun main() {
    val (a, b, c) = readLine()!!.split(' ').map { it.toInt() }
    print((a % c).power(b, c))
}

fun Int.power(k: Int, mod: Int): Int {
    if (k == 0) return 1
    val pw = this.power(k/2, mod).toLong()
    return if (k % 2 == 0)
        (pw * pw % mod).toInt()
    else
        ((pw * pw % mod) * this % mod).toInt()
}