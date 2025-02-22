fun main() {
    val (numberOfPeople, numberOfRounds, numberOfPresents) = readln().split(" ").map { it.toInt() }
    val think = List(numberOfPeople) { readln().toRSPList() }
    val board = List(numberOfRounds) { r -> think.map { it[r] } }

    var answer: State? = null
    val deque = ArrayDeque<State>()
    deque.add(State(0, List(numberOfPeople) { true }, listOf()))
    while (deque.isNotEmpty()) {
        val current = deque.removeFirst()
        when {
            current.count == 0 -> continue
            current.round != 0 && current.count <= numberOfPresents -> {
                answer = current
                break
            }
            current.round < numberOfRounds -> {
                deque.addLast(current.next(RSP.ROCK, board[current.round]))
                deque.addLast(current.next(RSP.SCISSORS, board[current.round]))
                deque.addLast(current.next(RSP.PAPER, board[current.round]))
            }
        }
    }
    println(answer ?: -1)
}

class State(val round: Int, val left: List<Boolean>, val step: List<RSP>) {
    val count = left.count { it }

    fun next(what: RSP, competitor: List<RSP>): State {
        return State(round + 1, competitor.mapIndexed { index: Int, rsp: RSP ->
            if (left[index]) {
                rsp > what
            } else false
        }, step + what)
    }

    override fun toString(): String {
        return """
            $round
            ${step.joinToString(separator = "")}
        """.trimIndent()
    }
}

sealed interface RSP {
    data object ROCK : RSP {
        override fun toString() = "R"
    }

    data object SCISSORS : RSP {
        override fun toString() = "S"
    }

    data object PAPER : RSP {
        override fun toString() = "P"
    }

    operator fun compareTo(other: RSP): Int {
        return when (this) {
            ROCK -> when (other) {
                ROCK -> 0
                SCISSORS -> 1
                PAPER -> -1
            }
            SCISSORS -> when (other) {
                ROCK -> -1
                SCISSORS -> 0
                PAPER -> 1
            }
            PAPER -> when (other) {
                ROCK -> 1
                SCISSORS -> -1
                PAPER -> 0
            }
        }
    }
}

fun String.toRSPList() = map {
    when (it) {
        'R' -> RSP.ROCK
        'S' -> RSP.SCISSORS
        'P' -> RSP.PAPER
        else -> throw IllegalArgumentException("Not a valid RSP: $this")
    }
}