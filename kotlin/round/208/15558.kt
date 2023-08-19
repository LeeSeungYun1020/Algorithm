fun main() {
    val (max, jump) = readln().split(" ").map { it.toInt() }
    val line = mapOf(
        Direction.LEFT to readln().map { it != '0' },
        Direction.RIGHT to readln().map { it != '0' }
    )

    val deque = ArrayDeque<Player>()
    deque.add(Player(0, Direction.LEFT, 0))

    val visited = mapOf(
        Direction.LEFT to MutableList(max) { false },
        Direction.RIGHT to MutableList(max) { false }
    )

    while (deque.isNotEmpty()) {
        val player = deque.removeFirst()

        if (player.position + jump >= max) {
            println(1)
            return
        }

        if (player.level == max) {
            continue
        }

        if (player.position >= player.level && line[player.direction]?.getOrNull(player.position + 1) == true) {
            if (visited[player.direction]?.getOrNull(player.position + 1) == false) {
                visited[player.direction]!![player.position + 1] = true
                deque.add(
                    Player(
                        level = player.level + 1,
                        direction = player.direction,
                        position = player.position + 1
                    )
                )
            }
        }

        if (player.position - 1 > player.level && line[player.direction]?.getOrNull(player.position - 1) == true) {
            if (visited[player.direction]?.getOrNull(player.position - 1) == false) {
                visited[player.direction]!![player.position - 1] = true
                deque.add(
                    Player(
                        level = player.level + 1,
                        direction = player.direction,
                        position = player.position - 1
                    )
                )
            }
        }

        if (player.position >= player.level && line[!player.direction]?.getOrNull(player.position + jump) == true) {
            if (visited[!player.direction]?.getOrNull(player.position + jump) == false) {
                visited[!player.direction]!![player.position + jump] = true
                deque.add(
                    Player(
                        level = player.level + 1,
                        direction = !player.direction,
                        position = player.position + jump
                    )
                )
            }
        }
    }
    println(0)
}

enum class Direction {
    LEFT, RIGHT;

    operator fun not(): Direction = if (this == LEFT) RIGHT else LEFT
}

data class Player(val level: Int, val direction: Direction, val position: Int)