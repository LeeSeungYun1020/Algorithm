fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val coin = mutableListOf<Int>()
    for (i in 1..n) {
        val c = readLine()!!.toInt()
        if (c > k) break
        coin.add(c)
    }
    var checker = k
    var ans = 0
    while (checker > 0) {
        while (coin.last() > checker) {
            coin.removeLast()
        }
        checker -= coin.last()
        ans++
    }
    print(ans)
}