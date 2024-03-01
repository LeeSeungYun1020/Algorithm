// 2^19 = 524_288로 19일까지만 이동 가능
const val MAX_DAY = 19
val POW_TWO = listOf(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144)

fun main() {
    val (n, pos1, pos2) = readln().split(" ").map { it.toInt() }
    val move = List(MAX_DAY + 1) { mutableSetOf<Int>() }
    val deque = ArrayDeque<State>()
    deque.add(State(0, pos1))
    while (deque.isNotEmpty()) {
        val (level, pos) = deque.removeFirst()
        if (level < MAX_DAY) {
            (pos - POW_TWO[level]).takeIf { it > 0 }?.let {
                move[level + 1].add(it)
                deque.add(State(level + 1, it))
            }
            (pos + POW_TWO[level]).takeIf { it <= n }?.let {
                move[level + 1].add(it)
                deque.add(State(level + 1, it))
            }
        }
    }
    deque.add(State(0, pos2))
    while (deque.isNotEmpty()) {
        val (level, pos) = deque.removeFirst()
        if (level < MAX_DAY) {
            if (move[level].contains(pos)) {
                println(level)
                return
            }
            (pos - POW_TWO[level]).takeIf { it > 0 }?.let { deque.add(State(level + 1, it)) }
            (pos + POW_TWO[level]).takeIf { it <= n }?.let { deque.add(State(level + 1, it)) }
        }
    }
    println(-1)
}

data class State(val level: Int, val pos: Int)