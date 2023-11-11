import Rock.*
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val board = List(n) { readln().split(" ").map { it.toRock() } }
    val states = List(n) { List(n) { Status() } }

    var mx = 0
    for (i in board.indices) {
        for (j in board[i].indices) {
            val topStateChecker = states.getOrNull(i - 1)?.get(j)?.top
            val leftStateChecker = states[i].getOrNull(j - 1)?.left
            val crossStateChecker = states.getOrNull(i - 1)?.getOrNull(j - 1)?.cross

            states[i][j].let { state ->
                when (board[i][j]) {
                    BLACK -> {
                        state.top.changed = (topStateChecker?.changed ?: 0) + 1
                        state.top.unChanged = (topStateChecker?.unChanged ?: 0) + 1

                        state.left.changed = (leftStateChecker?.changed ?: 0) + 1
                        state.left.unChanged = (leftStateChecker?.unChanged ?: 0) + 1

                        state.cross.changed = (crossStateChecker?.changed ?: 0) + 1
                        state.cross.unChanged = (crossStateChecker?.unChanged ?: 0) + 1

                        mx = maxOf(
                            mx,
                            state.top.changed,
                            state.top.unChanged,
                            state.left.changed,
                            state.left.unChanged,
                            state.cross.changed,
                            state.cross.unChanged
                        )
                    }
                    WHITE -> {
                        state.top.changed = (topStateChecker?.unChanged ?: 0) + 1
                        state.left.changed = (leftStateChecker?.unChanged ?: 0) + 1
                        state.cross.changed = (crossStateChecker?.unChanged ?: 0) + 1

                        mx = maxOf(
                            mx,
                            state.top.changed,
                            state.left.changed,
                            state.cross.changed,
                        )
                    }
                    EMPTY -> {}
                }
            }
        }
    }

    for (i in board.indices) {
        for (j in board[i].indices.reversed()) {
            val crossStateChecker = states.getOrNull(i - 1)?.getOrNull(j + 1)?.cross

            states[i][j].let { state ->
                state.cross.changed = 0
                state.cross.unChanged = 0
                when (board[i][j]) {
                    BLACK -> {
                        state.cross.changed = (crossStateChecker?.changed ?: 0) + 1
                        state.cross.unChanged = (crossStateChecker?.unChanged ?: 0) + 1

                        mx = maxOf(
                            mx,
                            state.cross.changed,
                            state.cross.unChanged
                        )
                    }
                    WHITE -> {
                        state.cross.changed = (crossStateChecker?.unChanged ?: 0) + 1

                        mx = max(
                            mx,
                            state.cross.changed,
                        )
                    }
                    EMPTY -> {}
                }
            }
        }
    }
    println(mx)
}

enum class Rock {
    BLACK, WHITE, EMPTY,
}

fun String.toRock() = when (this) {
    "0" -> EMPTY
    "1" -> BLACK
    "2" -> WHITE
    else -> EMPTY
}

data class Status(
    val top: Checker = Checker(),
    val left: Checker = Checker(),
    val cross: Checker = Checker(),
)

data class Checker(var changed: Int = 0, var unChanged: Int = 0)