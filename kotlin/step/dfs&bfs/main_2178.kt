fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val array = Array(n) { readLine()!!.map { it == '1' }.toBooleanArray() }
    val visited = Array(n) { BooleanArray(m) { false } }
    val deq = ArrayDeque<Triple<Int, Int, Int>>()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!visited[i][j] && array[i][j]) {
                deq.add(Triple(i, j, 1))
                while (deq.isNotEmpty()) {
                    val (x, y, level) = deq.removeFirst()
                    if (visited[x][y])
                        continue
                    visited[x][y] = true
                    if (x == n - 1 && y == m - 1) {
                        println(level)
                        return
                    }
                    if (visited.elementAtOrNull(x + 1)?.get(y) == false && array.elementAtOrNull(x + 1)?.get(y) == true) {
                        deq.add(Triple(x + 1, y, level + 1))
                    }
                    if (visited.elementAtOrNull(x - 1)?.get(y) == false && array.elementAtOrNull(x - 1)?.get(y) == true) {
                        deq.add(Triple(x - 1, y, level + 1))
                    }
                    if (visited[x].elementAtOrNull(y + 1) == false && array[x].elementAtOrNull(y + 1) == true) {
                        deq.add(Triple(x, y + 1, level + 1))
                    }
                    if (visited[x].elementAtOrNull(y - 1) == false && array[x].elementAtOrNull(y - 1) == true) {
                        deq.add(Triple(x, y - 1, level + 1))
                    }
                }
            }
        }
    }
}