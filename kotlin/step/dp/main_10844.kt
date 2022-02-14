fun main() {
    val num = readLine()!!.toInt()
    var prev = listOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    val now = mutableListOf<Int>()
    for (i in 1 until num) {
        now.clear()
        (0..9).forEach {
            now.add(it, when (it) {
                0 -> prev[it + 1]
                9 -> prev[it - 1]
                else -> (prev[it + 1] + prev[it - 1]) % 1000000000
            })
        }
        prev = now.toList()
    }
    println(prev.sumOf { it.toLong() } % 1000000000)
}