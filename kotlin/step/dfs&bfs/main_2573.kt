import IceState.*

data class Ice(val x: Int, val y: Int, val height: Int, val year: Int)
data class Position(val x: Int, val y: Int)
enum class IceState { MELT, CONNECTED, DISCONNECTED }

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val change = ArrayDeque<Ice>()
    val ice = List(n) {
        readln().split(" ").map {
            it.toInt()
        }.toMutableList()
    }
    var nowYear = 0

    fun nextYear() {
        while (change.isNotEmpty()) {
            val (x, y, height, year) = change.removeFirst()
            if (nowYear != year) {
                ice[x][y] = if (height < 0) 0 else height
                continue
            }
            var minus = 0
            for ((mx, my) in listOf(x - 1 to y, x to y - 1, x to y + 1, x + 1 to y)) {
                if (ice.getOrNull(mx)?.getOrNull(my) == 0) {
                    minus++
                }
            }
            change.add(Ice(x, y, height - minus, year + 1))
        }
    }

    fun isConnected(): IceState {
        val deque = ArrayDeque<Position>()
        val visited = List(n) { MutableList(m) { false } }
        var pass = false
        for (i in 1 until n - 1) {
            for (j in 1 until m - 1) {
                if (ice[i][j] != 0) {
                    change.add(Ice(i, j, ice[i][j], nowYear))
                    if (!visited[i][j]) {
                        if (!pass) {
                            visited[i][j] = true
                            pass = true
                            deque.add(Position(i, j))
                            while (deque.isNotEmpty()) {
                                val (x, y) = deque.removeFirst()
                                for ((mx, my) in listOf(x - 1 to y, x to y - 1, x to y + 1, x + 1 to y)) {
                                    if (ice.getOrNull(mx)?.getOrNull(my) != 0 && !visited[mx][my]) {
                                        visited[mx][my] = true
                                        deque.add(Position(mx, my))
                                    }
                                }
                            }
                        } else {
                            return DISCONNECTED
                        }
                    }
                }
            }
        }
        return if (pass)
            CONNECTED
        else
            MELT
    }

    while (true) {
        when (isConnected()) {
            MELT -> {
                println(0)
                return
            }
            CONNECTED -> {
                nextYear()
                nowYear++
            }
            DISCONNECTED -> {
                println(nowYear)
                return
            }
        }
    }
    println(0)
}