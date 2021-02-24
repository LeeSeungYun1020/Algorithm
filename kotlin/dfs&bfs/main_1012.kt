fun main() {
    val count = readLine()!!.toInt()
    for (i in 1..count) {
        val (n, m, k) = readLine()!!.split(' ').map { it.toInt() }
        val array = Array(n) { BooleanArray(m) { false } }
        for (j in 1..k) {
            val (x, y) = readLine()!!.split(' ').map { it.toInt() }
            array[x][y] = true
        }
        val visited = Array(n) { BooleanArray(m) { false } }
        val deq = ArrayDeque<Pair<Int, Int>>()
        var need = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (!visited[i][j] && array[i][j]) {
                    deq.add(i to j)
                    while (deq.isNotEmpty()) {
                        val (x, y) = deq.removeLast()
                        if (visited[x][y])
                            continue
                        visited[x][y] = true
                        if (visited.elementAtOrNull(x + 1)?.get(y) == false && array.elementAtOrNull(x + 1)?.get(y) == true) {
                            deq.add(x + 1 to y)
                        }
                        if (visited.elementAtOrNull(x - 1)?.get(y) == false && array.elementAtOrNull(x - 1)?.get(y) == true) {
                            deq.add(x - 1 to y)
                        }
                        if (visited[x].elementAtOrNull(y + 1) == false && array[x].elementAtOrNull(y + 1) == true) {
                            deq.add(x to y + 1)
                        }
                        if (visited[x].elementAtOrNull(y - 1) == false && array[x].elementAtOrNull(y - 1) == true) {
                            deq.add(x to y - 1)
                        }
                    }
                    need++
                }
            }
        }
        println(need)
    }

}