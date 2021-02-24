fun main() {
    val (m, n) = readLine()!!.split(' ').map { it.toInt() }
    val array = Array(n) { readLine()!!.split(' ').map { it.toInt() }.toIntArray() }
    val deq = ArrayDeque<Triple<Int, Int, Int>>()

    var tomato = m * n
    var count = 0
    var day = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            when (array[i][j]) {
                1 -> {
                    deq.add(Triple(i, j, 0))
                    count++
                }
                -1 -> tomato--
            }
        }
    }
    while (deq.isNotEmpty()) {
        val (x, y, level) = deq.removeFirst()
        day = level
        if (array.elementAtOrNull(x + 1)?.get(y) == 0) {
            deq.add(Triple(x + 1, y, level + 1))
            array[x + 1][y] = 1
            count++
        }
        if (array.elementAtOrNull(x - 1)?.get(y) == 0) {
            deq.add(Triple(x - 1, y, level + 1))
            array[x - 1][y] = 1
            count++
        }
        if (array[x].elementAtOrNull(y + 1) == 0) {
            deq.add(Triple(x, y + 1, level + 1))
            array[x][y + 1] = 1
            count++
        }
        if (array[x].elementAtOrNull(y - 1) == 0) {
            deq.add(Triple(x, y - 1, level + 1))
            array[x][y - 1] = 1
            count++
        }
    }
    if (count == tomato)
        println(day)
    else
        println(-1)
}