fun main() {
    val world = List(readln().split(" ").first().toInt()) {
        readln().split(" ").map { it.toInt() == 1 }.toMutableList()
    }

    var area = 0
    val deque = ArrayDeque<Pair<Int, Int>>()
    for (i in world.indices) {
        for (j in world[i].indices) {
            if (!world[i][j]) {
                area++
                world[i][j] = true
                deque.add(i to j)
                while (deque.isNotEmpty()) {
                    val (x, y) = deque.removeFirst()
                    for ((nX, nY) in listOf(
                        (if (x == 0) world.lastIndex else x - 1) to y,
                        (if (x == world.lastIndex) 0 else x + 1) to y,
                        x to (if (y == 0) world[x].lastIndex else y - 1),
                        x to (if (y == world[x].lastIndex) 0 else y + 1),
                    )) {
                        if (!world[nX][nY]) {
                            world[nX][nY] = true
                            deque.add(nX to nY)
                        }
                    }
                }
            }
        }
    }
    println(area)
}