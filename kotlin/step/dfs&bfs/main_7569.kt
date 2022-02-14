fun main() {
    val (m, n, h) = readLine()!!.split(' ').map { it.toInt() }
    val array = Array(h) { Array(n) { readLine()!!.split(' ').map { it.toInt() }.toIntArray() } }
    val deq = ArrayDeque<Pair<Triple<Int, Int, Int>, Int>>()

    var tomato = m * n * h
    var day = 0
    var count = 0
    for (i in 0 until h) {
        for (j in 0 until n) {
            for (k in 0 until m) {
                when (array[i][j][k]) {
                    1 -> deq.add(Triple(i, j, k) to 0)
                    -1 -> tomato--
                }
            }

        }
    }
    while (deq.isNotEmpty()) {
        val pos = deq.removeFirst()
        val (x, y, z) = pos.first
        val level = pos.second
        day = level
        count++
        if (array.getOrNull(x + 1)?.get(y)?.get(z) == 0) {
            deq.add(Triple(x + 1, y, z) to level + 1)
            array[x + 1][y][z] = 1
        }
        if (array.getOrNull(x - 1)?.get(y)?.get(z) == 0) {
            deq.add(Triple(x - 1, y, z) to level + 1)
            array[x - 1][y][z] = 1
        }
        if (array[x].getOrNull(y + 1)?.get(z) == 0) {
            deq.add(Triple(x, y + 1, z) to level + 1)
            array[x][y + 1][z] = 1
        }
        if (array[x].getOrNull(y - 1)?.get(z) == 0) {
            deq.add(Triple(x, y - 1, z) to level + 1)
            array[x][y - 1][z] = 1
        }
        if (array[x][y].getOrNull(z + 1) == 0) {
            deq.add(Triple(x, y, z + 1) to level + 1)
            array[x][y][z + 1] = 1
        }
        if (array[x][y].getOrNull(z - 1) == 0) {
            deq.add(Triple(x, y, z - 1) to level + 1)
            array[x][y][z - 1] = 1
        }
    }
    if (count == tomato)
        println(day)
    else
        println(-1)
}