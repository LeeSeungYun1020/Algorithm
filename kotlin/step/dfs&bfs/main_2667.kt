fun main() {
    val n = readLine()!!.toInt()
    val array = Array(n) { readLine()!!.map { it == '1' }.toBooleanArray() }
    val visited = Array(n) { BooleanArray(n) { false } }
    val deq = ArrayDeque<Pair<Int, Int>>()
    val block = mutableListOf<Int>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j] && array[i][j]) {
                var house = 0
                deq.add(i to j)
                while (deq.isNotEmpty()) {
                    val (x, y) = deq.removeLast()
                    if (visited[x][y])
                        continue
                    visited[x][y] = true
                    house++
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
                block.add(house)
            }
        }
    }
    println(block.size)
    block.sorted().forEach { println(it) }
}