enum class Direction {
    EAST {
        override fun move(position: Pair<Int, Int>): Pair<Int, Int> {
            return position.first to position.second+1
        }
    }, WEST {
        override fun move(position: Pair<Int, Int>): Pair<Int, Int> {
            return position.first to position.second-1
        }
    }, NORTH {
        override fun move(position: Pair<Int, Int>): Pair<Int, Int> {
            return position.first-1 to position.second
        }
    }, SOUTH {
        override fun move(position: Pair<Int, Int>): Pair<Int, Int> {
            return position.first+1 to position.second
        }
    };
    abstract fun move(position: Pair<Int, Int>): Pair<Int, Int>
}

fun Int.toDirection() = when(this) {
    1 -> Direction.EAST
    2 -> Direction.WEST
    3 -> Direction.NORTH
    else -> Direction.SOUTH
}

fun main() {
    val (n, m, x, y, k) = readln().split(" ").map { it.toInt() }
    val map = List(n) { readln().split(" ").map { it.toInt() }.toMutableList() }
    val command = readln().split(" ").map { it.toInt().toDirection() }

    val dice = MutableList(6) { 0 }
    /* 주사위 전개도
        1
      3 0 2
        4
        5
     0을 윗면으로 한다.
     */
    var pos = x to y
    for (c in command) {
        val (mx, my) = c.move(pos)
        val value = map.getOrNull(mx)?.getOrNull(my) ?: continue
        when(c) {
            Direction.EAST -> {
                val tem = dice[5]
                dice[5] = dice[2]
                dice[2] = dice[0]
                dice[0] = dice[3]
                dice[3] = tem
            }
            Direction.WEST -> {
                val tem = dice[0]
                dice[0] = dice[2]
                dice[2] = dice[5]
                dice[5] = dice[3]
                dice[3] = tem
            }
            Direction.NORTH -> {
                val tem = dice[0]
                dice[0] = dice[4]
                dice[4] = dice[5]
                dice[5] = dice[1]
                dice[1] = tem
            }
            Direction.SOUTH -> {
                val tem = dice[0]
                dice[0] = dice[1]
                dice[1] = dice[5]
                dice[5] = dice[4]
                dice[4] = tem
            }
        }
        pos = mx to my
        if (value == 0)
            map[mx][my] = dice[0]
        else {
            dice[0] = value
            map[mx][my] = 0
        }
        println(dice[5])
    }

}