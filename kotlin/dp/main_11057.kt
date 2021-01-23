fun main() {
    val num = readLine()!!.toInt()
    var prev = List(10) { 1 }

    for (i in 1 until num) {
        val now = MutableList(10) { 0 }
        for (j in 0..9) {
            for (k in j..9)
                now[k] = (now[k] + prev[j]) % 10007
        }
        prev = now.toList()
    }

    println(prev.sum() % 10007)
}