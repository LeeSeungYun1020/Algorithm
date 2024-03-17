fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val territory = List(r) { readln() }
    var (x, y) = readln().split(" ").map { it.toInt() - 1 }
    val route = readln()

    val eyeSight = List(r) { MutableList(c) { false } }
    val deque = ArrayDeque<Position>()

    // 경로 따라 이동
    for (move in route) {
        when (move) {
            'U' -> x--
            'D' -> x++
            'L' -> y--
            'R' -> y++
            'W' -> {
                // 영토 내 시야 확장
                val current = territory[x][y]
                eyeSight[x][y] = true
                deque.add(Position(x, y))

                while (deque.isNotEmpty()) {
                    val (cx, cy) = deque.removeFirst()
                    for ((mx, my) in listOf(
                        Position(cx - 1, cy),
                        Position(cx + 1, cy),
                        Position(cx, cy - 1),
                        Position(cx, cy + 1)
                    )) {
                        if (mx in 0 until r && my in 0 until c && territory[mx][my] == current && !eyeSight[mx][my]) {
                            eyeSight[mx][my] = true
                            deque.add(Position(mx, my))
                        }
                    }
                }
            }

            else -> throw IllegalArgumentException("Can't move to $move. U, D, L, R or W is required")
        }
    }

    // 현재 위치의 시야
    eyeSight[x][y] = true
    for ((mx, my) in listOf(
        Position(x - 1, y), Position(x + 1, y), Position(x, y - 1), Position(x, y + 1)
    )) {
        if (mx in 0 until r && my in 0 until c) {
            eyeSight[mx][my] = true
        }
    }

    // 출력
    println(eyeSight.joinToString(separator = "\n") {
        it.joinToString(separator = "") {
            if (it) "."
            else "#"
        }
    })
}

data class Position(val x: Int, val y: Int)